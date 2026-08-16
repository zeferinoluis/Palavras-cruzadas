package com.example.cruzadas.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.GridOn
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cruzadas.data.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun GeneratorScreen(
    viewModel: HomeViewModel,
    onPuzzleCreated: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    var themeInput by remember { mutableStateOf("") }
    var selectedDifficulty by remember { mutableStateOf("Médio") }

    val presetThemes = listOf(
        "Portugal",
        "Geografia",
        "História",
        "Entretenimento",
        "Artes e Literatura",
        "Ciências e Natureza",
        "Desporto e Lazer",
        "Saúde e Corpo",
        "Cultura Geral"
    )

    LaunchedEffect(uiState.generatedPuzzleId) {
        val puzzleId = uiState.generatedPuzzleId
        if (puzzleId != null) {
            viewModel.clearGeneratedEvent()
            onPuzzleCreated(puzzleId)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.AutoAwesome,
                            contentDescription = null,
                            tint = Color(0xFF6750A4)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text("Gerador de Cruzadas IA", fontWeight = FontWeight.Bold, color = Color(0xFF1D1B20))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFF7F2FA))
            )
        },
        containerColor = Color(0xFFF7F2FA),
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Intro Card
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color(0xFFCAC4D0), RoundedCornerShape(16.dp))
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color(0xFFEADDFF), RoundedCornerShape(12.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Psychology,
                            contentDescription = null,
                            tint = Color(0xFF21005D),
                            modifier = Modifier.size(28.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(14.dp))
                    Column {
                        Text(
                            text = "Gerador Infinito de Puzzles",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color(0xFF1D1B20)
                        )
                        Text(
                            text = "A IA pesquisa novas palavras e definições na internet para criar um desafio único.",
                            fontSize = 12.sp,
                            color = Color(0xFF625B71)
                        )
                    }
                }
            }

            // Theme Input Field
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "1. Escolha ou digite um Tema:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color(0xFF1D1B20)
                )

                OutlinedTextField(
                    value = themeInput,
                    onValueChange = { themeInput = it },
                    placeholder = { Text("Ex: Vinhos do Douro, Camões, Astronomia...", color = Color(0xFF49454F)) },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF6750A4),
                        unfocusedBorderColor = Color(0xFFCAC4D0),
                        focusedTextColor = Color(0xFF1D1B20),
                        unfocusedTextColor = Color(0xFF1D1B20),
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("input_generator_theme")
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Suggestion Pills
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    for (preset in presetThemes) {
                        Surface(
                            shape = RoundedCornerShape(20.dp),
                            color = if (themeInput == preset) Color(0xFFEADDFF) else Color(0xFFF3EDF7),
                            modifier = Modifier
                                .border(
                                    1.dp,
                                    if (themeInput == preset) Color(0xFF6750A4) else Color(0xFFCAC4D0),
                                    RoundedCornerShape(20.dp)
                                )
                                .clickable { themeInput = preset }
                        ) {
                            Text(
                                text = preset,
                                fontSize = 12.sp,
                                fontWeight = if (themeInput == preset) FontWeight.Bold else FontWeight.Medium,
                                color = if (themeInput == preset) Color(0xFF21005D) else Color(0xFF49454F),
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                            )
                        }
                    }
                }
            }

            // Difficulty Level Selection
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "2. Nível de Dificuldade & Tamanho:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color(0xFF1D1B20)
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    val difficulties = listOf("Fácil" to "8x8", "Médio" to "10x10", "Difícil" to "12x12")
                    for ((diff, sizeLabel) in difficulties) {
                        val isSel = selectedDifficulty == diff
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (isSel) Color(0xFFEADDFF) else Color.White
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .border(
                                    1.dp,
                                    if (isSel) Color(0xFF6750A4) else Color(0xFFCAC4D0),
                                    RoundedCornerShape(12.dp)
                                )
                                .clickable { selectedDifficulty = diff }
                                .testTag("btn_diff_$diff")
                        ) {
                            Column(
                                modifier = Modifier.padding(12.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = diff,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = if (isSel) Color(0xFF21005D) else Color(0xFF1D1B20)
                                )
                                Text(
                                    text = sizeLabel,
                                    fontSize = 11.sp,
                                    color = if (isSel) Color(0xFF6750A4) else Color(0xFF625B71)
                                )
                            }
                        }
                    }
                }
            }

            // Error Message
            if (uiState.errorMessage != null) {
                Text(
                    text = uiState.errorMessage ?: "",
                    color = Color(0xFFEF4444),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Generate Button
            Button(
                onClick = {
                    val themeToUse = if (themeInput.isBlank()) "Cultura Geral" else themeInput
                    val size = when (selectedDifficulty) {
                        "Fácil" -> 8
                        "Médio" -> 10
                        else -> 12
                    }
                    viewModel.generateAIPuzzle(
                        title = "Mente Ativa - $themeToUse",
                        theme = themeToUse,
                        difficulty = selectedDifficulty,
                        gridSize = size
                    )
                },
                enabled = !uiState.isGenerating,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEADDFF)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .testTag("btn_submit_generator")
            ) {
                if (uiState.isGenerating) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = Color(0xFF21005D),
                        strokeWidth = 3.dp
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "A pesquisar palavras & criar grelha...",
                        color = Color(0xFF21005D),
                        fontWeight = FontWeight.Bold
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.AutoAwesome,
                        contentDescription = null,
                        tint = Color(0xFF21005D)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Gerar Palavras Cruzadas com IA",
                        color = Color(0xFF21005D),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}
