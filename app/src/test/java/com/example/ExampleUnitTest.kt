package com.example

import com.example.cruzadas.data.generator.CrosswordGenerator
import com.example.cruzadas.data.seed.PrebuiltPuzzles
import org.junit.Assert.*
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun normalizeForGrid_separatesMultiWordsWithHash() {
        assertEquals("BALEIA#AZUL", CrosswordGenerator.normalizeForGrid("Baleia Azul"))
        assertEquals("CESAR#AUGUSTO", CrosswordGenerator.normalizeForGrid("César Augusto"))
        assertEquals("NICOLAU#II", CrosswordGenerator.normalizeForGrid("Nicolau II"))
        assertEquals("VASCO#DA#GAMA", CrosswordGenerator.normalizeForGrid("Vasco da Gama"))
    }

    @Test
    fun prebuiltPuzzles_areValidAndDistinct() {
        val puzzles = PrebuiltPuzzles.getInitialPuzzles()
        
        // Ensure all 18 prebuilt puzzles were generated
        assertEquals(18, puzzles.size)

        val puzzleIds = mutableSetOf<String>()

        for (puzzle in puzzles) {
            assertTrue("Duplicate puzzle ID: ${puzzle.id}", puzzleIds.add(puzzle.id))

            val placements = CrosswordGenerator.wordPlacementAdapter.fromJson(puzzle.wordsJson)
            assertNotNull("Words JSON must deserialize", placements)
            assertTrue("Puzzle ${puzzle.id} must have at least 3 words", placements!!.size >= 3)

            // Re-verify grid validity
            val grid = Array(puzzle.gridHeight) { CharArray(puzzle.gridWidth) { ' ' } }

            for (p in placements) {
                val word = p.word
                for (i in word.indices) {
                    val cx = if (p.direction == "ACROSS") p.startX + i else p.startX
                    val cy = if (p.direction == "DOWN") p.startY + i else p.startY

                    assertTrue("Cell ($cx, $cy) out of bounds for puzzle ${puzzle.id}", cx in 0 until puzzle.gridWidth && cy in 0 until puzzle.gridHeight)

                    val curr = grid[cy][cx]
                    if (curr != ' ') {
                        assertEquals("Letter mismatch at ($cx, $cy) in ${puzzle.id}", word[i], curr)
                    } else {
                        grid[cy][cx] = word[i]
                    }
                }
            }
        }
    }
}
