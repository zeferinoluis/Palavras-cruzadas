package com.example.cruzadas.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.GridOn
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cruzadas.data.models.Puzzle
import com.example.cruzadas.data.viewmodel.HomeUiState
import com.example.cruzadas.data.viewmodel.HomeViewModel
import com.example.cruzadas.data.viewmodel.UserStats

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onPlayPuzzle: (String) -> Unit,
    onNavigateToGenerator: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    val puzzles by viewModel.puzzlesList.collectAsState()
    val completedPuzzles by viewModel.completedPuzzlesList.collectAsState()
    val stats by viewModel.userStats.collectAsState()

    val categories = listOf(
        "Todos",
        "Desafio Diário",
        "Diário (Resolvidos)",
        "Portugal",
        "Geografia",
        "História",
        "Entretenimento",
        "Artes e Literatura",
        "Ciências e Natureza",
        "Desporto e Lazer",
        "Saúde e Corpo",
        "Cultura Geral",
        "Fácil",
        "Médio",
        "Difícil",
        "Gerados"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = Color(0xFFEADDFF),
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.GridOn,
                                    contentDescription = null,
                                    tint = Color(0xFF21005D),
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = "Palavras Cruzadas",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Color(0xFF1D1B20)
                            )
                            Text(
                                text = "MenteAtiva",
                                fontSize = 11.sp,
                                color = Color(0xFF625B71)
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF7F2FA)
                ),
                actions = {
                    Button(
                        onClick = onNavigateToGenerator,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEADDFF)),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .testTag("btn_create_ai")
                    ) {
                        Icon(
                            imageVector = Icons.Default.AutoAwesome,
                            contentDescription = "Criar IA",
                            tint = Color(0xFF21005D),
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Criar IA", color = Color(0xFF21005D), fontWeight = FontWeight.Bold, fontSize = 13.sp)
                    }
                }
            )
        },
        containerColor = Color(0xFFF7F2FA),
        modifier = modifier
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Compact Unified Header Card
            item {
                CompactDashboardHeader(
                    dailyPuzzle = uiState.todayDailyPuzzle,
                    stats = stats,
                    onPlayDailyClick = onPlayPuzzle,
                    onRefreshDailyClick = { viewModel.refreshTodayDailyChallenge() },
                    onOpenJournalClick = { viewModel.selectCategory("Diário (Resolvidos)") }
                )
            }

            // Category Filter Chips
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(categories) { category ->
                        FilterChip(
                            selected = uiState.selectedCategory == category,
                            onClick = { viewModel.selectCategory(category) },
                            label = { Text(category, fontWeight = FontWeight.SemiBold, fontSize = 12.sp) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = Color(0xFFEADDFF),
                                selectedLabelColor = Color(0xFF21005D),
                                containerColor = Color(0xFFF3EDF7),
                                labelColor = Color(0xFF49454F)
                            ),
                            border = FilterChipDefaults.filterChipBorder(
                                enabled = true,
                                selected = uiState.selectedCategory == category,
                                borderColor = Color(0xFFCAC4D0),
                                selectedBorderColor = Color(0xFF6750A4)
                            ),
                            modifier = Modifier.testTag("chip_category_$category")
                        )
                    }
                }
            }

            // Search Field Input
            item {
                OutlinedTextField(
                    value = uiState.searchQuery,
                    onValueChange = { viewModel.setSearchQuery(it) },
                    placeholder = {
                        Text(
                            "Pesquisar tema, título, palavra...",
                            fontSize = 13.sp,
                            color = Color(0xFF49454F)
                        )
                    },
                    textStyle = androidx.compose.ui.text.TextStyle(
                        fontSize = 14.sp,
                        color = Color(0xFF1D1B20),
                        fontWeight = FontWeight.Medium
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Pesquisar",
                            tint = Color(0xFF6750A4),
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    trailingIcon = {
                        if (uiState.searchQuery.isNotEmpty()) {
                            IconButton(onClick = { viewModel.setSearchQuery("") }) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Limpar",
                                    tint = Color(0xFF49454F),
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color(0xFF1D1B20),
                        unfocusedTextColor = Color(0xFF1D1B20),
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedBorderColor = Color(0xFF6750A4),
                        unfocusedBorderColor = Color(0xFFCAC4D0),
                        focusedPlaceholderColor = Color(0xFF49454F),
                        unfocusedPlaceholderColor = Color(0xFF49454F)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("input_search_puzzles")
                )
            }

            // Status Filter & Sort Row
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val statusOptions = listOf("Todos", "Não Iniciados", "Em Progresso")
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        statusOptions.forEach { status ->
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = if (uiState.statusFilter == status) Color(0xFF6750A4) else Color(0xFFF3EDF7),
                                modifier = Modifier
                                    .clickable { viewModel.setStatusFilter(status) }
                                    .testTag("filter_status_$status")
                            ) {
                                Text(
                                    text = status,
                                    fontSize = 11.sp,
                                    fontWeight = if (uiState.statusFilter == status) FontWeight.Bold else FontWeight.Medium,
                                    color = if (uiState.statusFilter == status) Color.White else Color(0xFF49454F),
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }
                    }

                    // Sort order button toggle
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFFEADDFF),
                        modifier = Modifier
                            .clickable {
                                val nextSort = when (uiState.sortOrder) {
                                    "Recentes" -> "Dificuldade"
                                    "Dificuldade" -> "Tempo"
                                    else -> "Recentes"
                                }
                                viewModel.setSortOrder(nextSort)
                            }
                            .testTag("btn_sort_order")
                    ) {
                        Text(
                            text = "Ordem: ${uiState.sortOrder}",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF21005D),
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            // Puzzles Section Title
            item {
                if (uiState.selectedCategory == "Diário (Resolvidos)") {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Diário de Desafios Resolvidos (${completedPuzzles.size})",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1D1B20)
                        )
                        Text(
                            text = "Desafios concluídos. Toque em qualquer um para repetir a qualquer momento.",
                            fontSize = 11.sp,
                            color = Color(0xFF625B71)
                        )
                    }
                } else {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "Desafios de Hoje (${puzzles.size})",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF1D1B20)
                            )
                            Text(
                                text = "Renovados diariamente em todos os temas e dificuldades",
                                fontSize = 11.sp,
                                color = Color(0xFF625B71)
                            )
                        }

                        Button(
                            onClick = { viewModel.refreshAllDailyChallenges() },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF3EDF7)),
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                            modifier = Modifier.testTag("btn_refresh_all_daily")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = "Renovar Todos",
                                tint = Color(0xFF6750A4),
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Renovar", color = Color(0xFF6750A4), fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                        }
                    }
                }
            }

            // Puzzles List
            if (uiState.selectedCategory == "Diário (Resolvidos)") {
                if (completedPuzzles.isEmpty()) {
                    item {
                        EmptyJournalView(onSelectAll = { viewModel.selectCategory("Todos") })
                    }
                } else {
                    items(completedPuzzles) { puzzle ->
                        PuzzleCardItem(
                            puzzle = puzzle,
                            onPlayClick = { onPlayPuzzle(puzzle.id) }
                        )
                    }
                }
            } else {
                if (puzzles.isEmpty()) {
                    item {
                        EmptyPuzzlesView(onGenerateClick = onNavigateToGenerator)
                    }
                } else {
                    items(puzzles) { puzzle ->
                        PuzzleCardItem(
                            puzzle = puzzle,
                            onPlayClick = { onPlayPuzzle(puzzle.id) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CompactDashboardHeader(
    dailyPuzzle: Puzzle?,
    stats: UserStats,
    onPlayDailyClick: (String) -> Unit,
    onRefreshDailyClick: () -> Unit,
    onOpenJournalClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color(0xFFCAC4D0), RoundedCornerShape(16.dp))
            .testTag("compact_dashboard_header")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            // Daily Challenge Strip
            if (dailyPuzzle != null) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFF6750A4),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "DESAFIO DO DIA",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White.copy(alpha = 0.9f)
                                )
                                if (stats.dailyStreak > 0) {
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = "🔥 ${stats.dailyStreak}d",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFFFD8E4)
                                    )
                                }
                            }
                            Text(
                                text = dailyPuzzle.title,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                maxLines = 1
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(
                                onClick = onRefreshDailyClick,
                                modifier = Modifier.size(28.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Refresh,
                                    contentDescription = "Novo Desafio",
                                    tint = Color.White,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(4.dp))
                            Button(
                                onClick = { onPlayDailyClick(dailyPuzzle.id) },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (dailyPuzzle.isCompleted) Color.White.copy(alpha = 0.25f) else Color(0xFFEADDFF)
                                ),
                                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                                modifier = Modifier.height(30.dp)
                            ) {
                                Text(
                                    text = if (dailyPuzzle.isCompleted) "Rever" else "Jogar",
                                    color = if (dailyPuzzle.isCompleted) Color.White else Color(0xFF21005D),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 11.sp
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
            }

            // Stats and Journal Bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CompactStatPill(
                        icon = Icons.Default.CheckCircle,
                        value = "${stats.completedCount}/${stats.totalCount}",
                        iconColor = Color(0xFF10B981)
                    )
                    CompactStatPill(
                        icon = Icons.Default.Star,
                        value = "${stats.totalStars}",
                        iconColor = Color(0xFF6750A4)
                    )
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFFF3EDF7),
                    modifier = Modifier
                        .clickable { onOpenJournalClick() }
                        .testTag("btn_open_solved_journal")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Book,
                            contentDescription = null,
                            tint = Color(0xFF6750A4),
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Diário (${stats.completedCount})",
                            color = Color(0xFF6750A4),
                            fontWeight = FontWeight.Bold,
                            fontSize = 11.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CompactStatPill(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    value: String,
    iconColor: Color
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = icon, contentDescription = null, tint = iconColor, modifier = Modifier.size(15.dp))
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = value, fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color(0xFF1D1B20))
    }
}

@Composable
private fun PuzzleCardItem(
    puzzle: Puzzle,
    onPlayClick: () -> Unit
) {
    val difficultyColor = when (puzzle.difficulty) {
        "Fácil" -> Color(0xFF10B981)
        "Médio" -> Color(0xFF6750A4)
        "Difícil" -> Color(0xFFEF4444)
        else -> Color(0xFF6750A4)
    }

    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color(0xFFCAC4D0), RoundedCornerShape(12.dp))
            .clickable { onPlayClick() }
            .testTag("puzzle_card_${puzzle.id}")
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Difficulty Badge Icon
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .background(Color(0xFFF3EDF7), RoundedCornerShape(8.dp))
                    .border(1.dp, Color(0xFFCAC4D0), RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${puzzle.gridWidth}x${puzzle.gridHeight}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = difficultyColor
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = puzzle.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color(0xFF1D1B20),
                        modifier = Modifier.weight(1f)
                    )
                    if (puzzle.isCompleted) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Concluído",
                            tint = Color(0xFF10B981),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(2.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = difficultyColor.copy(alpha = 0.15f)
                    ) {
                        Text(
                            text = puzzle.difficulty,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = difficultyColor,
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                        )
                    }

                    Text(
                        text = puzzle.category,
                        fontSize = 11.sp,
                        color = Color(0xFF625B71)
                    )
                }

                if (puzzle.elapsedSeconds > 0) {
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Tempo: ${formatSecondsToMinutes(puzzle.elapsedSeconds)}",
                        fontSize = 11.sp,
                        color = Color(0xFF6750A4)
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Box(
                modifier = Modifier
                    .size(34.dp)
                    .background(
                        if (puzzle.isCompleted) Color(0xFFF3EDF7) else Color(0xFFEADDFF),
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Jogar",
                    tint = Color(0xFF21005D),
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}

@Composable
private fun EmptyPuzzlesView(onGenerateClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.AutoAwesome,
            contentDescription = null,
            tint = Color(0xFF6750A4),
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Nenhum puzzle encontrado nesta categoria.",
            color = Color(0xFF1D1B20),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Crie um novo puzzle temático usando o Gerador com IA!",
            color = Color(0xFF625B71),
            fontSize = 13.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onGenerateClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEADDFF))
        ) {
            Text("Gerar Puzzle com IA", color = Color(0xFF21005D), fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun EmptyJournalView(onSelectAll: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Book,
            contentDescription = null,
            tint = Color(0xFF6750A4),
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "O seu Diário de Resolvidos está vazio.",
            color = Color(0xFF1D1B20),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Conclua palavras cruzadas nos desafios de hoje para as arquivar aqui e poder repeti-las a qualquer altura!",
            color = Color(0xFF625B71),
            fontSize = 13.sp,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onSelectAll,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEADDFF))
        ) {
            Text("Ver Desafios Ativos", color = Color(0xFF21005D), fontWeight = FontWeight.Bold)
        }
    }
}

private fun formatSecondsToMinutes(seconds: Long): String {
    val mins = seconds / 60
    val secs = seconds % 60
    return String.format("%02d:%02d", mins, secs)
}
