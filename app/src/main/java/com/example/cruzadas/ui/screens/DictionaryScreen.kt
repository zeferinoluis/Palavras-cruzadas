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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.GridOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cruzadas.data.models.DictionaryWord
import com.example.cruzadas.data.viewmodel.DictionaryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DictionaryScreen(
    viewModel: DictionaryViewModel,
    onPuzzleCreated: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState.createdPuzzleId) {
        val puzzleId = uiState.createdPuzzleId
        if (puzzleId != null) {
            viewModel.clearEvents()
            onPuzzleCreated(puzzleId)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Book,
                            contentDescription = null,
                            tint = Color(0xFF6750A4)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text("Dicionário & Pesquisa Online", fontWeight = FontWeight.Bold, color = Color(0xFF1D1B20))
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
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Search Input Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = uiState.searchQuery,
                    onValueChange = { viewModel.onSearchQueryChanged(it) },
                    placeholder = { Text("Pesquisar palavra...", color = Color(0xFF49454F)) },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = Color(0xFF625B71))
                    },
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
                        .weight(1f)
                        .testTag("input_dictionary_search")
                )

                // Web Search Online Button
                Button(
                    onClick = { viewModel.lookupOnlineDefinition() },
                    enabled = !uiState.isSearchingOnline && uiState.searchQuery.isNotBlank(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEADDFF)),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 12.dp),
                    modifier = Modifier.testTag("btn_online_lookup")
                ) {
                    if (uiState.isSearchingOnline) {
                        CircularProgressIndicator(modifier = Modifier.size(18.dp), color = Color(0xFF21005D), strokeWidth = 2.dp)
                    } else {
                        Icon(imageVector = Icons.Default.AutoAwesome, contentDescription = "Pesquisar Web", tint = Color(0xFF21005D), modifier = Modifier.size(18.dp))
                    }
                }
            }

            // Online Search Result Card Banner
            val onlineResult = uiState.onlineSearchResult
            if (onlineResult != null) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color(0xFFCAC4D0), RoundedCornerShape(16.dp))
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = onlineResult.word, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0xFF21005D))
                            Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFFEADDFF)) {
                                Text(text = onlineResult.category, fontSize = 11.sp, color = Color(0xFF6750A4), modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                            }
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(text = onlineResult.definition, fontSize = 13.sp, color = Color(0xFF1D1B20))

                        if (onlineResult.example.isNotBlank()) {
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = "Exemplo: \"${onlineResult.example}\"", fontSize = 12.sp, color = Color(0xFF625B71))
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        Button(
                            onClick = { viewModel.generatePuzzleForWord(onlineResult.word) },
                            enabled = !uiState.isGeneratingPuzzle,
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEADDFF)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("btn_gen_word_puzzle")
                        ) {
                            Icon(imageVector = Icons.Default.GridOn, contentDescription = null, tint = Color(0xFF21005D), modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Criar Cruzadas com '${onlineResult.word}'", color = Color(0xFF21005D), fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            Text(
                text = "Base de Palavras Disponíveis (${uiState.wordsList.size})",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color(0xFF1D1B20)
            )

            // Words List
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(uiState.wordsList) { item ->
                    DictionaryWordItem(
                        wordItem = item,
                        onGenerateClick = { viewModel.generatePuzzleForWord(item.word) }
                    )
                }
            }
        }
    }
}

@Composable
private fun DictionaryWordItem(
    wordItem: DictionaryWord,
    onGenerateClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color(0xFFCAC4D0), RoundedCornerShape(12.dp))
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = wordItem.word,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color(0xFF1D1B20)
                )
                Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = Color(0xFFF3EDF7)
                ) {
                    Text(
                        text = wordItem.category,
                        fontSize = 11.sp,
                        color = Color(0xFF6750A4),
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = wordItem.definition,
                fontSize = 13.sp,
                color = Color(0xFF49454F)
            )
        }
    }
}
