package com.example.cruzadas.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cruzadas.data.generator.CrosswordGenerator
import com.example.cruzadas.data.models.Puzzle
import com.example.cruzadas.data.models.WordPlacement
import com.example.cruzadas.data.repository.PuzzleRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.json.JSONObject

data class BoardCell(
    val x: Int,
    val y: Int,
    val isBlocked: Boolean,
    val startNumber: Int? = null,
    val correctChar: Char = ' ',
    val userChar: String = "",
    val isRevealed: Boolean = false,
    val checkStatus: CellCheckStatus = CellCheckStatus.NEUTRAL
)

enum class CellCheckStatus {
    NEUTRAL, CORRECT, INCORRECT
}

enum class WordDirection {
    ACROSS, DOWN
}

data class GameUiState(
    val puzzle: Puzzle? = null,
    val wordPlacements: List<WordPlacement> = emptyList(),
    val boardGrid: Map<Pair<Int, Int>, BoardCell> = emptyMap(),
    val selectedX: Int = -1,
    val selectedY: Int = -1,
    val direction: WordDirection = WordDirection.ACROSS,
    val activeWord: WordPlacement? = null,
    val elapsedSeconds: Long = 0L,
    val hintsUsed: Int = 0,
    val hintCredits: Int = 5,
    val isCompleted: Boolean = false,
    val isVictoryDialogVisible: Boolean = false,
    val isHintModalVisible: Boolean = false,
    val smartHintMessage: String? = null,
    val hintFeedbackMessage: String? = null,
    val isLoadingHint: Boolean = false,
    val starsEarned: Int = 3,
    val isDefinitionLookupVisible: Boolean = false,
    val searchWordQuery: String = "",
    val isSearchingDefinition: Boolean = false,
    val lookupResult: com.example.cruzadas.data.api.WordLookupResult? = null
)

class GameViewModel(
    private val repository: PuzzleRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    private var timerJob: Job? = null
    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    fun loadPuzzle(puzzleId: String) {
        viewModelScope.launch {
            repository.ensureInitialDataLoaded()
            val puzzle = repository.getPuzzleById(puzzleId) ?: return@launch
            val rawWords = CrosswordGenerator.wordPlacementAdapter.fromJson(puzzle.wordsJson) ?: emptyList()
            val words = rawWords.map { w ->
                if (w.displayWord.trim().contains(Regex("[\\s\\-_/.]+")) && !w.word.contains('#')) {
                    val normalized = CrosswordGenerator.normalizeForGrid(w.displayWord)
                    if (normalized.isNotBlank()) w.copy(word = normalized) else w
                } else {
                    w
                }
            }

            // Construct grid mapping
            val gridMap = mutableMapOf<Pair<Int, Int>, BoardCell>()
            for (y in 0 until puzzle.gridHeight) {
                for (x in 0 until puzzle.gridWidth) {
                    gridMap[Pair(x, y)] = BoardCell(x, y, isBlocked = true)
                }
            }

            // Populate words onto grid map
            for (w in words) {
                for (i in w.word.indices) {
                    val cx = if (w.direction == "ACROSS") w.startX + i else w.startX
                    val cy = if (w.direction == "DOWN") w.startY + i else w.startY
                    val key = Pair(cx, cy)
                    val ch = w.word[i]

                    if (ch == '#' || ch == ' ') {
                        // Black cell separator (casa negra)
                        val existing = gridMap[key]
                        if (existing == null || existing.correctChar == ' ') {
                            gridMap[key] = BoardCell(
                                x = cx,
                                y = cy,
                                isBlocked = true
                            )
                        }
                    } else {
                        val existing = gridMap[key] ?: BoardCell(cx, cy, isBlocked = false)

                        val startNum = if (i == 0) {
                            if (existing.startNumber != null) minOf(existing.startNumber, w.number) else w.number
                        } else existing.startNumber

                        gridMap[key] = existing.copy(
                            isBlocked = false,
                            startNumber = startNum,
                            correctChar = ch
                        )
                    }
                }
            }

            // Restore saved user grid state if available
            if (puzzle.userGridState.isNotBlank()) {
                try {
                    val json = JSONObject(puzzle.userGridState)
                    for (key in gridMap.keys) {
                        val keyStr = "${key.first}_${key.second}"
                        if (json.has(keyStr)) {
                            val savedVal = json.getString(keyStr)
                            val cell = gridMap[key]
                            if (cell != null && !cell.isBlocked) {
                                gridMap[key] = cell.copy(userChar = savedVal)
                            }
                        }
                    }
                } catch (e: Exception) {
                    // Ignore parse errors on saved state
                }
            }

            // Find initial active cell
            val firstWord = words.firstOrNull()
            var initialX = firstWord?.startX ?: 0
            var initialY = firstWord?.startY ?: 0
            if (firstWord != null && firstWord.word.isNotEmpty() && (firstWord.word[0] == '#' || firstWord.word[0] == ' ')) {
                val firstLetterIdx = firstWord.word.indexOfFirst { it != '#' && it != ' ' }.coerceAtLeast(0)
                initialX = if (firstWord.direction == "ACROSS") firstWord.startX + firstLetterIdx else firstWord.startX
                initialY = if (firstWord.direction == "DOWN") firstWord.startY + firstLetterIdx else firstWord.startY
            }

            _uiState.update {
                it.copy(
                    puzzle = puzzle,
                    wordPlacements = words,
                    boardGrid = gridMap,
                    selectedX = initialX,
                    selectedY = initialY,
                    direction = if (firstWord?.direction == "DOWN") WordDirection.DOWN else WordDirection.ACROSS,
                    elapsedSeconds = puzzle.elapsedSeconds,
                    hintsUsed = puzzle.hintsUsed,
                    isCompleted = puzzle.isCompleted,
                    isVictoryDialogVisible = false
                )
            }

            recalculateActiveWord()
            startTimer()
        }
    }

    private fun startTimer() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (true) {
                delay(1000L)
                if (!_uiState.value.isCompleted) {
                    _uiState.update { it.copy(elapsedSeconds = it.elapsedSeconds + 1) }
                    if (_uiState.value.elapsedSeconds % 5 == 0L) {
                        saveStateToDb()
                    }
                }
            }
        }
    }

    fun selectCell(x: Int, y: Int) {
        val cell = _uiState.value.boardGrid[Pair(x, y)] ?: return
        if (cell.isBlocked) return

        val currentX = _uiState.value.selectedX
        val currentY = _uiState.value.selectedY
        val currentDir = _uiState.value.direction

        if (currentX == x && currentY == y) {
            // Tapping same cell toggles direction if candidate word exists in other direction
            val otherDir = if (currentDir == WordDirection.ACROSS) WordDirection.DOWN else WordDirection.ACROSS
            if (hasWordInDirection(x, y, otherDir)) {
                _uiState.update { it.copy(direction = otherDir) }
            }
        } else {
            // Tapping new cell: keep current direction if valid for new cell, otherwise switch
            val validInCurrent = hasWordInDirection(x, y, currentDir)
            val dirToUse = if (validInCurrent) currentDir else {
                if (hasWordInDirection(x, y, WordDirection.DOWN)) WordDirection.DOWN else WordDirection.ACROSS
            }
            _uiState.update { it.copy(selectedX = x, selectedY = y, direction = dirToUse) }
        }

        recalculateActiveWord()
    }

    private fun isCellInWord(x: Int, y: Int, w: WordPlacement): Boolean {
        val idx = if (w.direction == "ACROSS") {
            if (y == w.startY && x in w.startX until (w.startX + w.word.length)) x - w.startX else -1
        } else {
            if (x == w.startX && y in w.startY until (w.startY + w.word.length)) y - w.startY else -1
        }
        return idx in w.word.indices && w.word[idx] != '#' && w.word[idx] != ' '
    }

    private fun hasWordInDirection(x: Int, y: Int, dir: WordDirection): Boolean {
        val dirStr = if (dir == WordDirection.ACROSS) "ACROSS" else "DOWN"
        return _uiState.value.wordPlacements.any { w ->
            w.direction == dirStr && isCellInWord(x, y, w)
        }
    }

    private fun recalculateActiveWord() {
        val x = _uiState.value.selectedX
        val y = _uiState.value.selectedY
        val dirStr = if (_uiState.value.direction == WordDirection.ACROSS) "ACROSS" else "DOWN"

        val active = _uiState.value.wordPlacements.firstOrNull { w ->
            w.direction == dirStr && isCellInWord(x, y, w)
        }

        _uiState.update { it.copy(activeWord = active) }
    }

    fun onKeyInput(charStr: String) {
        val currentState = _uiState.value
        val x = currentState.selectedX
        val y = currentState.selectedY
        if (x < 0 || y < 0 || currentState.isCompleted) return

        val cellKey = Pair(x, y)
        val currentCell = currentState.boardGrid[cellKey] ?: return
        if (currentCell.isBlocked || currentCell.isRevealed) return

        val normalizedChar = CrosswordGenerator.normalizeForGrid(charStr)
        if (normalizedChar.isBlank()) return

        val isCorrect = normalizedChar.first() == currentCell.correctChar
        val status = if (isCorrect) CellCheckStatus.NEUTRAL else CellCheckStatus.INCORRECT

        // Update cell with user input
        val updatedGrid = currentState.boardGrid.toMutableMap()
        updatedGrid[cellKey] = currentCell.copy(
            userChar = normalizedChar,
            checkStatus = status
        )

        _uiState.update { it.copy(boardGrid = updatedGrid) }

        // Automatically move to next cell in current word direction
        advanceSelection(forward = true)
        checkBoardCompletion()
    }

    fun onBackspace() {
        val currentState = _uiState.value
        val x = currentState.selectedX
        val y = currentState.selectedY
        if (x < 0 || y < 0 || currentState.isCompleted) return

        val cellKey = Pair(x, y)
        val currentCell = currentState.boardGrid[cellKey] ?: return

        val updatedGrid = currentState.boardGrid.toMutableMap()

        if (currentCell.userChar.isNotEmpty() && !currentCell.isRevealed) {
            // Clear current cell letter
            updatedGrid[cellKey] = currentCell.copy(userChar = "", checkStatus = CellCheckStatus.NEUTRAL)
            _uiState.update { it.copy(boardGrid = updatedGrid) }
        } else {
            // Move backward first, then clear
            advanceSelection(forward = false)
            val newX = _uiState.value.selectedX
            val newY = _uiState.value.selectedY
            val prevKey = Pair(newX, newY)
            val prevCell = updatedGrid[prevKey]
            if (prevCell != null && !prevCell.isBlocked && !prevCell.isRevealed) {
                updatedGrid[prevKey] = prevCell.copy(userChar = "", checkStatus = CellCheckStatus.NEUTRAL)
                _uiState.update { it.copy(boardGrid = updatedGrid) }
            }
        }
    }

    private fun advanceSelection(forward: Boolean) {
        val state = _uiState.value
        val active = state.activeWord ?: return
        val currentX = state.selectedX
        val currentY = state.selectedY

        val currentIdx = if (state.direction == WordDirection.ACROSS) currentX - active.startX else currentY - active.startY
        if (currentIdx !in active.word.indices) return

        if (forward) {
            var nextIdx = currentIdx + 1
            while (nextIdx < active.word.length && (active.word[nextIdx] == '#' || active.word[nextIdx] == ' ')) {
                nextIdx++
            }
            if (nextIdx < active.word.length) {
                val nextX = if (state.direction == WordDirection.ACROSS) active.startX + nextIdx else active.startX
                val nextY = if (state.direction == WordDirection.DOWN) active.startY + nextIdx else active.startY
                _uiState.update { it.copy(selectedX = nextX, selectedY = nextY) }
            }
        } else {
            var prevIdx = currentIdx - 1
            while (prevIdx >= 0 && (active.word[prevIdx] == '#' || active.word[prevIdx] == ' ')) {
                prevIdx--
            }
            if (prevIdx >= 0) {
                val prevX = if (state.direction == WordDirection.ACROSS) active.startX + prevIdx else active.startX
                val prevY = if (state.direction == WordDirection.DOWN) active.startY + prevIdx else active.startY
                _uiState.update { it.copy(selectedX = prevX, selectedY = prevY) }
            }
        }
    }

    fun selectNextClue() {
        val words = _uiState.value.wordPlacements
        if (words.isEmpty()) return
        val current = _uiState.value.activeWord
        val index = if (current != null) words.indexOf(current) else -1
        val nextIndex = (index + 1) % words.size
        val nextWord = words[nextIndex]

        val firstLetterIdx = nextWord.word.indexOfFirst { it != '#' && it != ' ' }.coerceAtLeast(0)
        val startX = if (nextWord.direction == "ACROSS") nextWord.startX + firstLetterIdx else nextWord.startX
        val startY = if (nextWord.direction == "DOWN") nextWord.startY + firstLetterIdx else nextWord.startY

        _uiState.update {
            it.copy(
                selectedX = startX,
                selectedY = startY,
                direction = if (nextWord.direction == "DOWN") WordDirection.DOWN else WordDirection.ACROSS,
                activeWord = nextWord
            )
        }
    }

    fun selectPreviousClue() {
        val words = _uiState.value.wordPlacements
        if (words.isEmpty()) return
        val current = _uiState.value.activeWord
        val index = if (current != null) words.indexOf(current) else 0
        val prevIndex = if (index - 1 < 0) words.size - 1 else index - 1
        val prevWord = words[prevIndex]

        val firstLetterIdx = prevWord.word.indexOfFirst { it != '#' && it != ' ' }.coerceAtLeast(0)
        val startX = if (prevWord.direction == "ACROSS") prevWord.startX + firstLetterIdx else prevWord.startX
        val startY = if (prevWord.direction == "DOWN") prevWord.startY + firstLetterIdx else prevWord.startY

        _uiState.update {
            it.copy(
                selectedX = startX,
                selectedY = startY,
                direction = if (prevWord.direction == "DOWN") WordDirection.DOWN else WordDirection.ACROSS,
                activeWord = prevWord
            )
        }
    }

    fun checkErrors() {
        val grid = _uiState.value.boardGrid.toMutableMap()
        for ((key, cell) in grid) {
            if (!cell.isBlocked && cell.userChar.isNotEmpty()) {
                val status = if (cell.userChar.first() == cell.correctChar) CellCheckStatus.CORRECT else CellCheckStatus.INCORRECT
                grid[key] = cell.copy(checkStatus = status)
            }
        }
        _uiState.update { it.copy(boardGrid = grid) }
    }

    fun openHintModal() {
        _uiState.update { it.copy(isHintModalVisible = true) }
    }

    fun dismissHintModal() {
        _uiState.update { it.copy(isHintModalVisible = false) }
    }

    fun clearFeedbackMessage() {
        _uiState.update { it.copy(hintFeedbackMessage = null) }
    }

    fun addBonusCredits(amount: Int = 3) {
        _uiState.update {
            it.copy(
                hintCredits = it.hintCredits + amount,
                hintFeedbackMessage = "+$amount Créditos de Dicas adicionados!"
            )
        }
    }

    fun revealCurrentCell() {
        val credits = _uiState.value.hintCredits
        if (credits < 1) {
            _uiState.update { it.copy(hintFeedbackMessage = "Sem créditos suficientes! Obtenha mais bónus de dicas.") }
            return
        }

        val x = _uiState.value.selectedX
        val y = _uiState.value.selectedY
        val cellKey = Pair(x, y)
        val cell = _uiState.value.boardGrid[cellKey] ?: return
        if (cell.isBlocked) return

        val updatedGrid = _uiState.value.boardGrid.toMutableMap()
        updatedGrid[cellKey] = cell.copy(
            userChar = cell.correctChar.toString(),
            isRevealed = true,
            checkStatus = CellCheckStatus.CORRECT
        )

        _uiState.update {
            it.copy(
                boardGrid = updatedGrid,
                hintsUsed = it.hintsUsed + 1,
                hintCredits = it.hintCredits - 1,
                hintFeedbackMessage = "Letra revelada! (-1 crédito)",
                isHintModalVisible = false
            )
        }

        checkBoardCompletion()
    }

    fun revealActiveWord() {
        val credits = _uiState.value.hintCredits
        if (credits < 2) {
            _uiState.update { it.copy(hintFeedbackMessage = "Necessita de pelo menos 2 créditos para revelar a palavra inteira!") }
            return
        }

        val active = _uiState.value.activeWord ?: return
        val updatedGrid = _uiState.value.boardGrid.toMutableMap()

        for (i in active.word.indices) {
            if (active.word[i] == '#' || active.word[i] == ' ') continue
            val cx = if (active.direction == "ACROSS") active.startX + i else active.startX
            val cy = if (active.direction == "DOWN") active.startY + i else active.startY
            val key = Pair(cx, cy)
            val cell = updatedGrid[key] ?: continue
            if (cell.isBlocked) continue

            updatedGrid[key] = cell.copy(
                userChar = cell.correctChar.toString(),
                isRevealed = true,
                checkStatus = CellCheckStatus.CORRECT
            )
        }

        _uiState.update {
            it.copy(
                boardGrid = updatedGrid,
                hintsUsed = it.hintsUsed + 2,
                hintCredits = it.hintCredits - 2,
                hintFeedbackMessage = "Palavra inteira revelada! (-2 créditos)",
                isHintModalVisible = false
            )
        }

        checkBoardCompletion()
    }

    fun requestSmartHint() {
        val credits = _uiState.value.hintCredits
        if (credits < 1) {
            _uiState.update { it.copy(hintFeedbackMessage = "Sem créditos suficientes para a Dica IA!") }
            return
        }

        val active = _uiState.value.activeWord ?: return
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoadingHint = true,
                    smartHintMessage = null,
                    isHintModalVisible = false
                )
            }
            val hint = repository.getSmartHint(active.word, active.clue)
            _uiState.update {
                it.copy(
                    isLoadingHint = false,
                    smartHintMessage = hint,
                    hintsUsed = it.hintsUsed + 1,
                    hintCredits = it.hintCredits - 1,
                    hintFeedbackMessage = "Dica IA gerada! (-1 crédito)"
                )
            }
        }
    }

    fun clearSmartHintMessage() {
        _uiState.update { it.copy(smartHintMessage = null) }
    }

    fun openDefinitionLookup(initialQuery: String? = null) {
        val defaultQuery = initialQuery ?: _uiState.value.activeWord?.word ?: ""
        _uiState.update {
            it.copy(
                isDefinitionLookupVisible = true,
                searchWordQuery = defaultQuery,
                lookupResult = null,
                isHintModalVisible = false
            )
        }
    }

    fun onSearchWordQueryChanged(query: String) {
        _uiState.update { it.copy(searchWordQuery = query) }
    }

    fun lookupWordDefinition() {
        val query = _uiState.value.searchWordQuery.trim()
        if (query.isBlank()) return
        viewModelScope.launch {
            _uiState.update { it.copy(isSearchingDefinition = true, lookupResult = null) }
            val result = repository.lookupAndAddWord(query)
            _uiState.update {
                it.copy(
                    isSearchingDefinition = false,
                    lookupResult = result
                )
            }
        }
    }

    fun dismissDefinitionLookup() {
        _uiState.update {
            it.copy(
                isDefinitionLookupVisible = false,
                searchWordQuery = "",
                lookupResult = null
            )
        }
    }

    private fun checkBoardCompletion() {
        val grid = _uiState.value.boardGrid
        val playableCells = grid.values.filter { !it.isBlocked }

        val isAllFilled = playableCells.all { it.userChar.isNotEmpty() }
        val isAllCorrect = playableCells.all { it.userChar.firstOrNull() == it.correctChar }

        if (isAllFilled && isAllCorrect && !_uiState.value.isCompleted) {
            // Calculate stars (3 stars for no hints, 2 for 1-2 hints, 1 for >2 hints)
            val hints = _uiState.value.hintsUsed
            val stars = when {
                hints == 0 -> 3
                hints in 1..2 -> 2
                else -> 1
            }

            _uiState.update {
                it.copy(
                    isCompleted = true,
                    isVictoryDialogVisible = true,
                    starsEarned = stars
                )
            }
            saveStateToDb()
        }
    }

    fun dismissVictoryDialog() {
        _uiState.update { it.copy(isVictoryDialogVisible = false) }
    }

    private fun saveStateToDb() {
        val state = _uiState.value
        val puzzleId = state.puzzle?.id ?: return

        // Build user state json
        val json = JSONObject()
        for ((key, cell) in state.boardGrid) {
            if (!cell.isBlocked && cell.userChar.isNotEmpty()) {
                json.put("${key.first}_${key.second}", cell.userChar)
            }
        }

        viewModelScope.launch {
            repository.updatePuzzleProgress(
                id = puzzleId,
                userGridState = json.toString(),
                elapsedSeconds = state.elapsedSeconds,
                hintsUsed = state.hintsUsed,
                isCompleted = state.isCompleted,
                stars = state.starsEarned
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        saveStateToDb()
        timerJob?.cancel()
    }
}
