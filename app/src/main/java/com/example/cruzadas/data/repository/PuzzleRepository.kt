package com.example.cruzadas.data.repository

import com.example.cruzadas.data.api.GeminiDictionaryService
import com.example.cruzadas.data.api.WordLookupResult
import com.example.cruzadas.data.db.DictionaryDao
import com.example.cruzadas.data.db.PuzzleDao
import com.example.cruzadas.data.generator.CrosswordGenerator
import com.example.cruzadas.data.models.DictionaryWord
import com.example.cruzadas.data.models.Puzzle
import com.example.cruzadas.data.seed.PrebuiltPuzzles
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class PuzzleRepository(
    private val puzzleDao: PuzzleDao,
    private val dictionaryDao: DictionaryDao
) {

    val allPuzzles: Flow<List<Puzzle>> = puzzleDao.getAllPuzzles()
    val allDictionaryWords: Flow<List<DictionaryWord>> = dictionaryDao.getAllWords()

    suspend fun ensureInitialDataLoaded() {
        val words = dictionaryDao.getAllWords().first()
        val initialDict = PrebuiltPuzzles.getInitialDictionaryWords()
        if (words.size < initialDict.size || words.none { it.category == "Geografia" } || words.none { it.category == "Entretenimento" } || words.none { it.category == "História" } || words.none { it.category == "Desporto e Lazer" }) {
            dictionaryDao.insertWords(initialDict)
        }

        // Renew daily puzzles across all categories and difficulty levels
        renewDailyPuzzlesForAllThemes(forceRefresh = false)

        // Always ensure today's featured daily challenge exists
        ensureDailyChallengeForToday()
    }

    private fun hasUnseparatedMultiWords(wordsJson: String): Boolean {
        val placements = CrosswordGenerator.wordPlacementAdapter.fromJson(wordsJson) ?: return false
        return placements.any { p ->
            val hasMultipleWords = p.displayWord.trim().contains(Regex("[\\s\\-_/.]+"))
            val hasHash = p.word.contains('#')
            hasMultipleWords && !hasHash
        }
    }

    suspend fun renewDailyPuzzlesForAllThemes(forceRefresh: Boolean = false) {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val dateStr = sdf.format(Date())
        val initialPuzzles = PrebuiltPuzzles.getInitialPuzzles()

        for (basePuzzle in initialPuzzles) {
            val id = basePuzzle.id
            val existing = puzzleDao.getPuzzleById(id)

            val isToday = existing != null && isSameCalendarDay(existing.createdAt, System.currentTimeMillis())
            val hasOutdatedWords = existing != null && hasUnseparatedMultiWords(existing.wordsJson)

            if (existing != null && isToday && !forceRefresh && !hasOutdatedWords) {
                // Today's puzzle for this theme and difficulty is already active and up to date
                continue
            }

            // Archive completed old puzzle if it exists from a previous date or before forced refresh
            if (existing != null && existing.isCompleted && !hasOutdatedWords) {
                val oldDateStr = sdf.format(Date(existing.createdAt))
                val archivedId = "${id}_$oldDateStr"
                val archivedPuzzle = existing.copy(id = archivedId)
                puzzleDao.insertPuzzle(archivedPuzzle)
            }

            // Generate fresh new daily puzzle for today for this category and difficulty
            val seed = (dateStr + id + if (forceRefresh) System.currentTimeMillis().toString() else "").hashCode().toLong()
            val candidates = getCandidatesForPuzzle(basePuzzle)

            var freshPuzzle = CrosswordGenerator.generateCrossword(
                title = basePuzzle.title,
                difficulty = basePuzzle.difficulty,
                category = basePuzzle.category,
                targetWidth = basePuzzle.gridWidth,
                targetHeight = basePuzzle.gridHeight,
                wordPool = candidates,
                customId = id,
                seed = seed
            )

            if (freshPuzzle == null) {
                freshPuzzle = basePuzzle.copy(
                    createdAt = System.currentTimeMillis(),
                    isCompleted = false,
                    userGridState = "",
                    elapsedSeconds = 0,
                    hintsUsed = 0,
                    stars = 0
                )
            }

            puzzleDao.insertPuzzle(freshPuzzle)
        }
    }

    private suspend fun getCandidatesForPuzzle(basePuzzle: Puzzle): List<CrosswordGenerator.CandidateWord> {
        val placements = CrosswordGenerator.wordPlacementAdapter.fromJson(basePuzzle.wordsJson) ?: emptyList()
        val baseCandidates = placements.map {
            CrosswordGenerator.CandidateWord(
                originalWord = it.displayWord,
                clue = it.clue,
                category = basePuzzle.category
            )
        }

        val dictWords = dictionaryDao.getAllWords().first()
            .filter { it.category.equals(basePuzzle.category, ignoreCase = true) || basePuzzle.category == "Geral" }
            .map { CrosswordGenerator.CandidateWord(originalWord = it.word, clue = it.definition, category = it.category) }

        return (baseCandidates + dictWords).distinctBy { it.normalizedWord }
    }

    private fun isSameCalendarDay(time1: Long, time2: Long): Boolean {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return sdf.format(Date(time1)) == sdf.format(Date(time2))
    }

    suspend fun ensureDailyChallengeForToday(): Puzzle {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val dateStr = sdf.format(Date())
        val dailyId = "daily_$dateStr"

        val existing = puzzleDao.getPuzzleById(dailyId)
        if (existing != null && !hasUnseparatedMultiWords(existing.wordsJson)) {
            return existing
        }

        return createDailyChallengeForDate(dateStr)
    }

    suspend fun createDailyChallengeForDate(dateStr: String): Puzzle {
        val dailyId = "daily_$dateStr"
        val displayFormat = SimpleDateFormat("d 'de' MMMM", Locale("pt", "PT"))

        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = try { sdf.parse(dateStr) ?: Date() } catch (e: Exception) { Date() }
        val displayDate = displayFormat.format(date)

        val cal = Calendar.getInstance().apply { time = date }
        val dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)
        val (theme, difficulty) = when (dayOfWeek) {
            Calendar.MONDAY -> "História" to "Fácil"
            Calendar.TUESDAY -> "Ciência" to "Médio"
            Calendar.WEDNESDAY -> "Cultura" to "Médio"
            Calendar.THURSDAY -> "Gastronomia" to "Fácil"
            Calendar.FRIDAY -> "Geografia" to "Médio"
            Calendar.SATURDAY -> "Literatura" to "Difícil"
            else -> "Geral" to "Médio"
        }

        val title = "Desafio Diário - $displayDate"

        // Local pool matching theme
        val localWords = dictionaryDao.getAllWords().first()
            .filter { it.category.equals(theme, ignoreCase = true) || theme == "Geral" }
            .map { CrosswordGenerator.CandidateWord(originalWord = it.word, clue = it.definition, category = it.category) }

        // Fetch candidates online via Gemini/Internal generator
        val onlineWords = GeminiDictionaryService.generateThematicWords(theme, difficulty, count = 14)
        val combinedPool = (onlineWords + localWords).distinctBy { it.normalizedWord }

        var generated = CrosswordGenerator.generateCrossword(
            title = title,
            difficulty = difficulty,
            category = "Desafio Diário",
            targetWidth = 10,
            targetHeight = 10,
            wordPool = combinedPool,
            customId = dailyId
        )

        if (generated == null) {
            val fallbackPool = PrebuiltPuzzles.getInitialDictionaryWords().map {
                CrosswordGenerator.CandidateWord(it.word, CrosswordGenerator.normalizeForGrid(it.word), it.definition, it.category)
            }
            generated = CrosswordGenerator.generateCrossword(
                title = title,
                difficulty = difficulty,
                category = "Desafio Diário",
                targetWidth = 10,
                targetHeight = 10,
                wordPool = fallbackPool,
                customId = dailyId
            )
        }

        val finalPuzzle = generated ?: Puzzle(
            id = dailyId,
            title = title,
            difficulty = difficulty,
            category = "Desafio Diário",
            gridWidth = 10,
            gridHeight = 10,
            wordsJson = "[]"
        )

        puzzleDao.insertPuzzle(finalPuzzle)
        return finalPuzzle
    }

    suspend fun calculateDailyStreak(): Int {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val cal = Calendar.getInstance()
        var streak = 0

        // Check backwards starting from today
        for (i in 0..30) { // Check up to 30 days back
            val dateStr = sdf.format(cal.time)
            val puzzle = puzzleDao.getPuzzleById("daily_$dateStr")
            if (puzzle != null && puzzle.isCompleted) {
                streak++
            } else if (i > 0) {
                // If today is not completed yet, keep checking yesterday. If yesterday is not completed, streak ends.
                break
            }
            cal.add(Calendar.DAY_OF_YEAR, -1)
        }
        return streak
    }

    suspend fun getPuzzleById(id: String): Puzzle? {
        return puzzleDao.getPuzzleById(id)
    }

    suspend fun updatePuzzleProgress(
        id: String,
        userGridState: String,
        elapsedSeconds: Long,
        hintsUsed: Int,
        isCompleted: Boolean,
        stars: Int
    ) {
        puzzleDao.updatePuzzleProgress(
            id = id,
            userState = userGridState,
            elapsed = elapsedSeconds,
            hints = hintsUsed,
            completed = isCompleted,
            stars = stars
        )
    }

    suspend fun generateCustomPuzzle(
        title: String,
        theme: String,
        difficulty: String,
        gridSize: Int
    ): Puzzle? {
        // Fetch base local seed words matching category or difficulty
        val localSeedWords = dictionaryDao.getAllWords().first()
            .filter { it.category.equals(theme, ignoreCase = true) || theme == "Geral" || it.difficulty.equals(difficulty, ignoreCase = true) }
            .map { CrosswordGenerator.CandidateWord(it.word, CrosswordGenerator.normalizeForGrid(it.word), it.definition, it.category) }

        // Fetch online candidates via Gemini API / Internet search
        val onlineCandidates = GeminiDictionaryService.generateThematicWords(theme, difficulty, count = 15)

        // Combine local seed pool and online candidates for rich, unique crosswords
        val combinedWordPool = (onlineCandidates + localSeedWords).distinctBy { it.normalizedWord }

        val generatedPuzzle = CrosswordGenerator.generateCrossword(
            title = if (title.isBlank()) "Desafio - $theme" else title,
            difficulty = difficulty,
            category = theme,
            targetWidth = gridSize,
            targetHeight = gridSize,
            wordPool = combinedWordPool
        )

        if (generatedPuzzle != null) {
            puzzleDao.insertPuzzle(generatedPuzzle)
            // Also store newly generated words in local dictionary
            for (candidate in onlineCandidates) {
                dictionaryDao.insertWord(
                    DictionaryWord(
                        word = candidate.originalWord,
                        definition = candidate.clue,
                        category = theme,
                        difficulty = difficulty,
                        isCustom = true
                    )
                )
            }
        }

        return generatedPuzzle
    }

    suspend fun searchDictionary(query: String): List<DictionaryWord> {
        if (query.isBlank()) {
            return dictionaryDao.getAllWords().first()
        }
        return dictionaryDao.searchWords(query).first()
    }

    suspend fun lookupAndAddWord(word: String): WordLookupResult {
        val result = GeminiDictionaryService.lookupWordDefinition(word)
        if (result.definition.isNotBlank()) {
            dictionaryDao.insertWord(
                DictionaryWord(
                    word = result.word,
                    definition = result.definition,
                    category = result.category,
                    difficulty = result.difficulty,
                    isCustom = true
                )
            )
        }
        return result
    }

    suspend fun getSmartHint(word: String, clue: String): String {
        return GeminiDictionaryService.getSmartHint(word, clue)
    }
}
