package com.example.cruzadas.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class WordPlacement(

    val id: Int,
    val number: Int,
    val word: String, // Normalized uppercase without accents for grid matching (e.g., "LUSITANO")
    val displayWord: String, // Original accented word for display (e.g., "Lusitano")
    val clue: String,
    val startX: Int,
    val startY: Int,
    val direction: String // "ACROSS" or "DOWN"
)

@Entity(tableName = "puzzles")
data class Puzzle(
    @PrimaryKey val id: String,
    val title: String,
    val difficulty: String, // "Fácil", "Médio", "Difícil", "Temático", "Gerado"
    val category: String, // "História", "Cultura", "Geral", "Ciência", etc.
    val gridWidth: Int,
    val gridHeight: Int,
    val wordsJson: String, // Serialized List<WordPlacement>
    val isCompleted: Boolean = false,
    val userGridState: String = "", // Serialized JSON string of Map<CellCoordKey, String>
    val elapsedSeconds: Long = 0L,
    val hintsUsed: Int = 0,
    val stars: Int = 0,
    val createdAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "dictionary_words")
data class DictionaryWord(
    @PrimaryKey val word: String,
    val definition: String,
    val category: String,
    val difficulty: String,
    val isCustom: Boolean = false
)
