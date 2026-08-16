package com.example.cruzadas.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cruzadas.data.api.WordLookupResult
import com.example.cruzadas.data.models.DictionaryWord
import com.example.cruzadas.data.repository.PuzzleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class DictionaryUiState(
    val searchQuery: String = "",
    val wordsList: List<DictionaryWord> = emptyList(),
    val isSearchingOnline: Boolean = false,
    val onlineSearchResult: WordLookupResult? = null,
    val isGeneratingPuzzle: Boolean = false,
    val createdPuzzleId: String? = null,
    val errorMessage: String? = null
)

class DictionaryViewModel(
    private val repository: PuzzleRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DictionaryUiState())
    val uiState: StateFlow<DictionaryUiState> = _uiState.asStateFlow()

    init {
        loadWords("")
    }

    fun onSearchQueryChanged(query: String) {
        _uiState.update { it.copy(searchQuery = query, onlineSearchResult = null, errorMessage = null) }
        loadWords(query)
    }

    private fun loadWords(query: String) {
        viewModelScope.launch {
            val words = repository.searchDictionary(query)
            _uiState.update { it.copy(wordsList = words) }
        }
    }

    fun lookupOnlineDefinition(wordToSearch: String? = null) {
        val word = wordToSearch ?: _uiState.value.searchQuery
        if (word.isBlank()) return

        viewModelScope.launch {
            _uiState.update { it.copy(isSearchingOnline = true, errorMessage = null) }
            val result = repository.lookupAndAddWord(word)
            _uiState.update {
                it.copy(
                    isSearchingOnline = false,
                    onlineSearchResult = result
                )
            }
            loadWords(_uiState.value.searchQuery)
        }
    }

    fun generatePuzzleForWord(word: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isGeneratingPuzzle = true, createdPuzzleId = null, errorMessage = null) }
            val puzzle = repository.generateCustomPuzzle(
                title = "Puzzle Especial - $word",
                theme = word,
                difficulty = "Médio",
                gridSize = 10
            )
            if (puzzle != null) {
                _uiState.update { it.copy(isGeneratingPuzzle = false, createdPuzzleId = puzzle.id) }
            } else {
                _uiState.update { it.copy(isGeneratingPuzzle = false, errorMessage = "Não foi possível gerar um puzzle com esta palavra.") }
            }
        }
    }

    fun clearEvents() {
        _uiState.update { it.copy(createdPuzzleId = null, errorMessage = null) }
    }
}
