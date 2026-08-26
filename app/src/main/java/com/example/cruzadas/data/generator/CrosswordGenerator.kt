package com.example.cruzadas.data.generator

import com.example.cruzadas.data.models.DictionaryWord
import com.example.cruzadas.data.models.Puzzle
import com.example.cruzadas.data.models.WordPlacement
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.text.Normalizer
import java.util.UUID

object CrosswordGenerator {

    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    private val wordPlacementListType = Types.newParameterizedType(List::class.java, WordPlacement::class.java)
    val wordPlacementAdapter = moshi.adapter<List<WordPlacement>>(wordPlacementListType)

    /**
     * Helper to normalize Portuguese words into uppercase unaccented A-Z for the grid matching.
     * Separates multi-word entries with '#' to represent black separator cells (casas negras).
     * e.g., "Caravela" -> "CARAVELA", "Baleia Azul" -> "BALEIA#AZUL", "Nicolau II" -> "NICOLAU#II"
     */
    fun normalizeForGrid(word: String): String {
        val rawTokens = word.trim().split(Regex("[\\s\\-_/.]+")).filter { it.isNotBlank() }
        val normalizedTokens = rawTokens.map { token ->
            val nfdNormalized = Normalizer.normalize(token.uppercase(), Normalizer.Form.NFD)
            val regex = "\\p{InCombiningDiacriticalMarks}+".toRegex()
            regex.replace(nfdNormalized, "").replace("Ç", "C").replace("[^A-Z0-9]".toRegex(), "")
        }.filter { it.isNotBlank() }

        return if (normalizedTokens.isEmpty()) "" else normalizedTokens.joinToString("#")
    }

    data class CandidateWord(
        val originalWord: String,
        val clue: String = "",
        val category: String = "Geral"
    ) {
        val normalizedWord: String = normalizeForGrid(originalWord)

        constructor(originalWord: String, normalizedWord: String, clue: String, category: String) : this(
            originalWord = originalWord,
            clue = clue,
            category = category
        )
    }

    /**
     * Generates a crossword grid given a pool of candidate words and target dimensions.
     */
    fun generateCrossword(
        title: String,
        difficulty: String,
        category: String,
        targetWidth: Int = 10,
        targetHeight: Int = 10,
        wordPool: List<CandidateWord>,
        customId: String? = null,
        seed: Long? = null
    ): Puzzle? {
        val validCandidates = wordPool
            .map { CandidateWord(it.originalWord, normalizeForGrid(it.originalWord), it.clue, it.category) }
            .filter { cand ->
                val len = cand.normalizedWord.length
                val hasChars = cand.normalizedWord.any { it in 'A'..'Z' || it in '0'..'9' }
                len in 3..targetWidth.coerceAtLeast(targetHeight) && hasChars
            }
            .distinctBy { it.normalizedWord }

        if (validCandidates.isEmpty()) return null

        val random = if (seed != null) java.util.Random(seed) else java.util.Random()

        val maxTargetWords = when (difficulty) {
            "Fácil" -> 4
            "Médio" -> 8
            "Difícil" -> 10
            else -> 6
        }
        val minTargetWords = when (difficulty) {
            "Fácil" -> 4
            "Médio" -> 6
            "Difícil" -> 8
            else -> 4
        }

        var bestPlacedWords = listOf<WordPlacement>()
        val candidatesList = validCandidates.shuffled(random).sortedByDescending { it.normalizedWord.length }.toMutableList()

        for (attempt in 0..15) {
            if (attempt > 0) {
                val first = candidatesList.removeAt(0)
                candidatesList.shuffle(random)
                candidatesList.add(attempt % candidatesList.size.coerceAtLeast(1), first)
            }

            val grid = Array(targetHeight) { CharArray(targetWidth) { ' ' } }
            val currentPlaced = mutableListOf<WordPlacement>()

            // 1. Place the first word
            val first = candidatesList.first()
            val startX = (targetWidth - first.normalizedWord.length) / 2
            val startY = targetHeight / 2

            for (i in first.normalizedWord.indices) {
                grid[startY][startX + i] = first.normalizedWord[i]
            }

            currentPlaced.add(
                WordPlacement(
                    id = 1,
                    number = 1,
                    word = first.normalizedWord,
                    displayWord = first.originalWord,
                    clue = first.clue,
                    startX = startX,
                    startY = startY,
                    direction = "ACROSS"
                )
            )

            // 2. Iteratively place intersecting words
            var idCounter = 2
            for (candidate in candidatesList.drop(1)) {
                if (currentPlaced.size >= maxTargetWords) break

                var bestPlacement: WordPlacement? = null

                placementLoop@ for (placed in currentPlaced) {
                    for (i in candidate.normalizedWord.indices) {
                        val candChar = candidate.normalizedWord[i]
                        if (candChar == '#' || candChar == ' ') continue // Separators (black cells) cannot form intersections

                        for (j in placed.word.indices) {
                            val placedChar = placed.word[j]
                            if (placedChar == '#' || placedChar == ' ') continue // Separators (black cells) cannot form intersections

                            if (placedChar == candChar) {
                                val intersectX = if (placed.direction == "ACROSS") placed.startX + j else placed.startX
                                val intersectY = if (placed.direction == "ACROSS") placed.startY else placed.startY + j

                                val newDir = if (placed.direction == "ACROSS") "DOWN" else "ACROSS"
                                val newStartX = if (newDir == "ACROSS") intersectX - i else intersectX
                                val newStartY = if (newDir == "DOWN") intersectY - i else intersectY

                                if (canPlaceWord(grid, candidate.normalizedWord, newStartX, newStartY, newDir, targetWidth, targetHeight)) {
                                    bestPlacement = WordPlacement(
                                        id = idCounter,
                                        number = 0,
                                        word = candidate.normalizedWord,
                                        displayWord = candidate.originalWord,
                                        clue = candidate.clue,
                                        startX = newStartX,
                                        startY = newStartY,
                                        direction = newDir
                                    )
                                    break@placementLoop
                                }
                            }
                        }
                    }
                }

                if (bestPlacement != null) {
                    val w = bestPlacement.word
                    val dir = bestPlacement.direction
                    val sx = bestPlacement.startX
                    val sy = bestPlacement.startY

                    for (idx in w.indices) {
                        val cx = if (dir == "ACROSS") sx + idx else sx
                        val cy = if (dir == "DOWN") sy + idx else sy
                        grid[cy][cx] = w[idx]
                    }

                    currentPlaced.add(bestPlacement)
                    idCounter++
                }
            }

            if (currentPlaced.size > bestPlacedWords.size) {
                bestPlacedWords = currentPlaced
            }

            // Stop if we met or exceeded the minimum target requirement
            if (currentPlaced.size in minTargetWords..maxTargetWords) {
                bestPlacedWords = currentPlaced
                break
            }
        }

        val placedWords = bestPlacedWords
        if (placedWords.isEmpty()) return null

        // 3. Assign word numbers (1..N) based on starting cell order (row-first, col-second)
        val cellStartMap = mutableMapOf<Pair<Int, Int>, Int>()
        var currentNumber = 1

        val sortedStarts = placedWords
            .map { Pair(it.startY, it.startX) }
            .distinct()
            .sortedWith(compareBy({ it.first }, { it.second }))

        for (startPos in sortedStarts) {
            cellStartMap[startPos] = currentNumber++
        }

        val numberedPlacedWords = placedWords.map { placement ->
            val num = cellStartMap[Pair(placement.startY, placement.startX)] ?: 1
            placement.copy(number = num)
        }

        val jsonWords = wordPlacementAdapter.toJson(numberedPlacedWords)

        return Puzzle(
            id = customId ?: ("gen_" + UUID.randomUUID().toString().take(8)),
            title = title,
            difficulty = difficulty,
            category = category,
            gridWidth = targetWidth,
            gridHeight = targetHeight,
            wordsJson = jsonWords,
            isCompleted = false
        )
    }

    private fun canPlaceWord(
        grid: Array<CharArray>,
        word: String,
        startX: Int,
        startY: Int,
        direction: String,
        width: Int,
        height: Int
    ): Boolean {
        if (startX < 0 || startY < 0) return false
        val endX = if (direction == "ACROSS") startX + word.length - 1 else startX
        val endY = if (direction == "DOWN") startY + word.length - 1 else startY

        if (endX >= width || endY >= height) return false

        // Check boundaries immediately before and after the word to ensure space separation
        if (direction == "ACROSS") {
            if (startX > 0 && grid[startY][startX - 1] != ' ' && grid[startY][startX - 1] != '#') return false
            if (endX < width - 1 && grid[startY][endX + 1] != ' ' && grid[startY][endX + 1] != '#') return false
        } else {
            if (startY > 0 && grid[startY - 1][startX] != ' ' && grid[startY - 1][startX] != '#') return false
            if (endY < height - 1 && grid[endY + 1][startX] != ' ' && grid[endY + 1][startX] != '#') return false
        }

        for (i in word.indices) {
            val cx = if (direction == "ACROSS") startX + i else startX
            val cy = if (direction == "DOWN") startY + i else startY

            val existingChar = grid[cy][cx]
            val currentChar = word[i]

            if (currentChar == '#' || currentChar == ' ') {
                // This is a separator black cell (casa negra).
                // It cannot overwrite an existing letter!
                if (existingChar != ' ' && existingChar != '#' && existingChar != ' ') {
                    return false
                }
                continue
            }

            // Playable letter cell:
            if (existingChar != ' ' && existingChar != currentChar) {
                return false // Character collision mismatch or attempting to write letter onto a black cell '#'
            }

            // Check adjacent parallel cells to prevent illegal parallel word touching
            if (existingChar == ' ') {
                if (direction == "ACROSS") {
                    if (cy > 0 && grid[cy - 1][cx] != ' ' && grid[cy - 1][cx] != '#') return false
                    if (cy < height - 1 && grid[cy + 1][cx] != ' ' && grid[cy + 1][cx] != '#') return false
                } else {
                    if (cx > 0 && grid[cy][cx - 1] != ' ' && grid[cy][cx - 1] != '#') return false
                    if (cx < width - 1 && grid[cy][cx + 1] != ' ' && grid[cy][cx + 1] != '#') return false
                }
            }
        }

        return true
    }
}
