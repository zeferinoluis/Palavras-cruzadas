package com.example.cruzadas.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cruzadas.data.models.Puzzle
import com.example.cruzadas.data.repository.PuzzleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class ThemeStat(
    val category: String,
    val completedCount: Int,
    val totalCount: Int,
    val percentage: Float
)

data class UserStats(
    val completedCount: Int = 0,
    val totalCount: Int = 0,
    val totalStars: Int = 0,
    val totalTimeSeconds: Long = 0L,
    val accuracyPercentage: Int = 100,
    val dailyStreak: Int = 0,
    val completedDailyCount: Int = 0,
    val avgTimePerPuzzleSeconds: Long = 0L,
    val totalHintsUsed: Int = 0,
    val themeStatsList: List<ThemeStat> = emptyList(),
    val rankTitle: String = "Iniciante do Léxico"
)

data class HomeUiState(
    val selectedCategory: String = "Todos",
    val searchQuery: String = "",
    val statusFilter: String = "Todos", // "Todos", "Não Iniciados", "Em Progresso", "Concluídos"
    val sortOrder: String = "Recentes", // "Recentes", "Dificuldade", "Tempo"
    val isGenerating: Boolean = false,
    val generatedPuzzleId: String? = null,
    val errorMessage: String? = null,
    val todayDailyPuzzle: Puzzle? = null,
    val showSolvedJournal: Boolean = false
)

class HomeViewModel(
    private val repository: PuzzleRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.ensureInitialDataLoaded()
            loadTodayDailyPuzzle()
        }
    }

    fun loadTodayDailyPuzzle() {
        viewModelScope.launch {
            val daily = repository.ensureDailyChallengeForToday()
            _uiState.update { it.copy(todayDailyPuzzle = daily) }
        }
    }

    val puzzlesList: StateFlow<List<Puzzle>> = repository.allPuzzles
        .combine(_uiState) { puzzles, state ->
            // Keep today's daily puzzle state in sync with repository
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val todayId = "daily_${sdf.format(Date())}"
            val currentDailyInDb = puzzles.find { it.id == todayId }
            if (currentDailyInDb != null && currentDailyInDb != state.todayDailyPuzzle) {
                _uiState.update { it.copy(todayDailyPuzzle = currentDailyInDb) }
            }

            // 1. Category Filter
            var filtered = when (state.selectedCategory) {
                "Todos" -> puzzles.filter { !it.isCompleted }
                "Diário (Resolvidos)" -> puzzles.filter { it.isCompleted }
                "Desafio Diário" -> puzzles.filter { !it.isCompleted && (it.category == "Desafio Diário" || it.id.startsWith("daily_")) }
                "Fácil" -> puzzles.filter { !it.isCompleted && it.difficulty == "Fácil" }
                "Médio" -> puzzles.filter { !it.isCompleted && it.difficulty == "Médio" }
                "Difícil" -> puzzles.filter { !it.isCompleted && it.difficulty == "Difícil" }
                "Temático" -> puzzles.filter { !it.isCompleted && it.difficulty == "Temático" }
                "Gerados" -> puzzles.filter { !it.isCompleted && it.id.startsWith("gen_") }
                else -> puzzles.filter { !it.isCompleted && it.category.equals(state.selectedCategory, ignoreCase = true) }
            }

            // 2. Status Filter
            filtered = when (state.statusFilter) {
                "Não Iniciados" -> filtered.filter { !it.isCompleted && it.elapsedSeconds == 0L }
                "Em Progresso" -> filtered.filter { !it.isCompleted && it.elapsedSeconds > 0L }
                "Concluídos" -> filtered.filter { it.isCompleted }
                else -> filtered
            }

            // 3. Search Filter
            if (state.searchQuery.isNotBlank()) {
                val query = state.searchQuery.trim().lowercase(Locale.getDefault())
                filtered = filtered.filter { puzzle ->
                    puzzle.title.lowercase(Locale.getDefault()).contains(query) ||
                    puzzle.category.lowercase(Locale.getDefault()).contains(query) ||
                    puzzle.difficulty.lowercase(Locale.getDefault()).contains(query) ||
                    puzzle.wordsJson.lowercase(Locale.getDefault()).contains(query)
                }
            }

            // 4. Sorting
            when (state.sortOrder) {
                "Dificuldade" -> filtered.sortedBy {
                    when (it.difficulty) {
                        "Fácil" -> 1
                        "Médio" -> 2
                        "Difícil" -> 3
                        else -> 4
                    }
                }
                "Tempo" -> filtered.sortedByDescending { it.elapsedSeconds }
                else -> filtered.sortedByDescending { it.createdAt } // "Recentes"
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    val userStats: StateFlow<UserStats> = repository.allPuzzles
        .combine(_uiState) { puzzles, _ ->
            val completed = puzzles.filter { it.isCompleted }
            val dailyPuzzles = puzzles.filter { it.id.startsWith("daily_") }
            val completedDaily = dailyPuzzles.count { it.isCompleted }
            val streak = repository.calculateDailyStreak()
            val totalTime = puzzles.sumOf { it.elapsedSeconds }
            val totalHints = puzzles.sumOf { it.hintsUsed }
            val totalStars = completed.sumOf { it.stars }
            val avgTime = if (completed.isNotEmpty()) completed.sumOf { it.elapsedSeconds } / completed.size else 0L

            // Category Breakdown Stats
            val categoriesList = listOf("Portugal", "Geografia", "História", "Entretenimento", "Artes e Literatura", "Ciências e Natureza", "Desporto e Lazer", "Saúde e Corpo", "Cultura Geral")
            val themeStats = categoriesList.map { cat ->
                val catPuzzles = puzzles.filter { it.category.equals(cat, ignoreCase = true) }
                val catCompleted = catPuzzles.count { it.isCompleted }
                val catTotal = catPuzzles.size
                val pct = if (catTotal > 0) (catCompleted.toFloat() / catTotal) else 0f
                ThemeStat(
                    category = cat,
                    completedCount = catCompleted,
                    totalCount = catTotal,
                    percentage = pct
                )
            }

            val rank = when {
                totalStars >= 50 -> "Sábio MenteAtiva 👑"
                totalStars >= 30 -> "Mestre Vocabular ⭐"
                totalStars >= 15 -> "Especialista em Cruzadas 🎯"
                totalStars >= 5 -> "Explorador de Palavras 🔍"
                else -> "Iniciante do Léxico 🌱"
            }

            UserStats(
                completedCount = completed.size,
                totalCount = puzzles.size,
                totalStars = totalStars,
                totalTimeSeconds = totalTime,
                accuracyPercentage = if (puzzles.isEmpty()) 100 else ((completed.size.toDouble() / puzzles.size) * 100).toInt(),
                dailyStreak = streak,
                completedDailyCount = completedDaily,
                avgTimePerPuzzleSeconds = avgTime,
                totalHintsUsed = totalHints,
                themeStatsList = themeStats,
                rankTitle = rank
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = UserStats()
        )

    val completedPuzzlesList: StateFlow<List<Puzzle>> = repository.allPuzzles
        .map { puzzles -> puzzles.filter { it.isCompleted }.sortedByDescending { it.createdAt } }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun setSearchQuery(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun setStatusFilter(filter: String) {
        _uiState.update { it.copy(statusFilter = filter) }
    }

    fun setSortOrder(order: String) {
        _uiState.update { it.copy(sortOrder = order) }
    }

    fun toggleSolvedJournal(show: Boolean) {
        _uiState.update { it.copy(showSolvedJournal = show) }
    }

    fun selectCategory(category: String) {
        _uiState.update { it.copy(selectedCategory = category) }
    }

    fun refreshTodayDailyChallenge() {
        viewModelScope.launch {
            _uiState.update { it.copy(isGenerating = true) }
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val dateStr = sdf.format(Date())
            val newDaily = repository.createDailyChallengeForDate(dateStr)
            _uiState.update { it.copy(todayDailyPuzzle = newDaily, isGenerating = false) }
        }
    }

    fun refreshAllDailyChallenges() {
        viewModelScope.launch {
            _uiState.update { it.copy(isGenerating = true) }
            repository.renewDailyPuzzlesForAllThemes(forceRefresh = true)
            val daily = repository.ensureDailyChallengeForToday()
            _uiState.update { it.copy(todayDailyPuzzle = daily, isGenerating = false) }
        }
    }

    fun generateAIPuzzle(title: String, theme: String, difficulty: String, gridSize: Int) {
        viewModelScope.launch {
            _uiState.update { it.copy(isGenerating = true, errorMessage = null, generatedPuzzleId = null) }
            val newPuzzle = repository.generateCustomPuzzle(title, theme, difficulty, gridSize)
            if (newPuzzle != null) {
                _uiState.update { it.copy(isGenerating = false, generatedPuzzleId = newPuzzle.id) }
            } else {
                _uiState.update { it.copy(isGenerating = false, errorMessage = "Não foi possível gerar um puzzle com estas palavras. Tente outro tema!") }
            }
        }
    }

    fun clearGeneratedEvent() {
        _uiState.update { it.copy(generatedPuzzleId = null, errorMessage = null) }
    }
}
