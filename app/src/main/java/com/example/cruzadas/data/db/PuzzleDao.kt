package com.example.cruzadas.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cruzadas.data.models.DictionaryWord
import com.example.cruzadas.data.models.Puzzle
import kotlinx.coroutines.flow.Flow

@Dao
interface PuzzleDao {
    @Query("SELECT * FROM puzzles ORDER BY createdAt DESC")
    fun getAllPuzzles(): Flow<List<Puzzle>>

    @Query("SELECT * FROM puzzles WHERE id = :id")
    suspend fun getPuzzleById(id: String): Puzzle?

    @Query("SELECT * FROM puzzles WHERE difficulty = :difficulty ORDER BY createdAt DESC")
    fun getPuzzlesByDifficulty(difficulty: String): Flow<List<Puzzle>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPuzzles(puzzles: List<Puzzle>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPuzzle(puzzle: Puzzle)

    @Query("UPDATE puzzles SET userGridState = :userState, elapsedSeconds = :elapsed, hintsUsed = :hints, isCompleted = :completed, stars = :stars WHERE id = :id")
    suspend fun updatePuzzleProgress(id: String, userState: String, elapsed: Long, hints: Int, completed: Boolean, stars: Int)

    @Query("DELETE FROM puzzles WHERE id = :id")
    suspend fun deletePuzzle(id: String)
}

@Dao
interface DictionaryDao {
    @Query("SELECT * FROM dictionary_words ORDER BY word ASC")
    fun getAllWords(): Flow<List<DictionaryWord>>

    @Query("SELECT * FROM dictionary_words WHERE word LIKE '%' || :query || '%' OR definition LIKE '%' || :query || '%'")
    fun searchWords(query: String): Flow<List<DictionaryWord>>

    @Query("SELECT * FROM dictionary_words WHERE difficulty = :difficulty")
    suspend fun getWordsByDifficulty(difficulty: String): List<DictionaryWord>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: DictionaryWord)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWords(words: List<DictionaryWord>)
}
