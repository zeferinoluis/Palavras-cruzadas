package com.example.cruzadas.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cruzadas.data.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatsScreen(
    viewModel: HomeViewModel,
    modifier: Modifier = Modifier
) {
    val stats by viewModel.userStats.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.BarChart, contentDescription = null, tint = Color(0xFF6750A4))
                        Spacer(modifier = Modifier.width(10.dp))
                        Text("Estatísticas Mente Ativa", fontWeight = FontWeight.Bold, color = Color(0xFF1D1B20))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFF7F2FA))
            )
        },
        containerColor = Color(0xFFF7F2FA),
        modifier = modifier
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(14.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Rank Banner
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color(0xFFCAC4D0), RoundedCornerShape(16.dp))
                        .testTag("card_rank_banner")
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(52.dp)
                                .background(Color(0xFFEADDFF), RoundedCornerShape(14.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.EmojiEvents,
                                contentDescription = null,
                                tint = Color(0xFF21005D),
                                modifier = Modifier.size(32.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(14.dp))
                        Column {
                            Text(
                                text = stats.rankTitle,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF1D1B20)
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "${stats.totalStars * 150} Pontos Léxicos • Accerto Global ${stats.accuracyPercentage}%",
                                fontSize = 12.sp,
                                color = Color(0xFF625B71)
                            )
                        }
                    }
                }
            }

            // Grid Metrics Cards (Row 1)
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    BigStatCard(
                        title = "Sequência",
                        value = "${stats.dailyStreak} Dias",
                        subtext = "dias seguidos",
                        icon = Icons.Default.CalendarMonth,
                        iconColor = Color(0xFFEC4899),
                        modifier = Modifier.weight(1f)
                    )

                    BigStatCard(
                        title = "Concluídos",
                        value = "${stats.completedCount}/${stats.totalCount}",
                        subtext = "desafios totais",
                        icon = Icons.Default.CheckCircle,
                        iconColor = Color(0xFF10B981),
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            // Grid Metrics Cards (Row 2)
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    BigStatCard(
                        title = "Estrelas",
                        value = "${stats.totalStars}",
                        subtext = "obtidamente",
                        icon = Icons.Default.Star,
                        iconColor = Color(0xFF6750A4),
                        modifier = Modifier.weight(1f)
                    )

                    BigStatCard(
                        title = "Tempo Total",
                        value = formatSecondsToMinutes(stats.totalTimeSeconds),
                        subtext = "em jogo",
                        icon = Icons.Default.Timer,
                        iconColor = Color(0xFF6750A4),
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            // Grid Metrics Cards (Row 3 - Advanced Performance)
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    BigStatCard(
                        title = "Média / Desafio",
                        value = formatSecondsToMinutes(stats.avgTimePerPuzzleSeconds),
                        subtext = "por cruzada",
                        icon = Icons.Default.Speed,
                        iconColor = Color(0xFF0284C7),
                        modifier = Modifier.weight(1f)
                    )

                    BigStatCard(
                        title = "Dicas Usadas",
                        value = "${stats.totalHintsUsed}",
                        subtext = "pistas pedidas",
                        icon = Icons.Default.Lightbulb,
                        iconColor = Color(0xFFEAB308),
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            // Theme Category Progress Breakdown
            item {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Progresso por Tema Cultural",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1D1B20)
                )
            }

            items(stats.themeStatsList) { themeStat ->
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color(0xFFCAC4D0), RoundedCornerShape(12.dp))
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = themeStat.category,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = Color(0xFF1D1B20)
                            )
                            Text(
                                text = "${themeStat.completedCount} de ${themeStat.totalCount} (${(themeStat.percentage * 100).toInt()}%)",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF6750A4)
                            )
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        LinearProgressIndicator(
                            progress = { themeStat.percentage },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp),
                            color = Color(0xFF6750A4),
                            trackColor = Color(0xFFEADDFF),
                            strokeCap = StrokeCap.Round
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun BigStatCard(
    title: String,
    value: String,
    subtext: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    iconColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = modifier.border(1.dp, Color(0xFFCAC4D0), RoundedCornerShape(12.dp))
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Icon(imageVector = icon, contentDescription = null, tint = iconColor, modifier = Modifier.size(22.dp))
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = value, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1D1B20))
            Text(text = title, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF49454F))
            Text(text = subtext, fontSize = 10.sp, color = Color(0xFF625B71))
        }
    }
}

private fun formatSecondsToMinutes(seconds: Long): String {
    val mins = seconds / 60
    val secs = seconds % 60
    return String.format("%02d:%02d", mins, secs)
}
