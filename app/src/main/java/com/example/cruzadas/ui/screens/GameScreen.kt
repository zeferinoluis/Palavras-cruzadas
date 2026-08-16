package com.example.cruzadas.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.NavigateBefore
import androidx.compose.material.icons.automirrored.filled.NavigateNext
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cruzadas.ui.components.CrosswordBoardGrid
import com.example.cruzadas.ui.components.VirtualKeyboard
import com.example.cruzadas.data.viewmodel.GameViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(
    puzzleId: String,
    viewModel: GameViewModel,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(puzzleId) {
        viewModel.loadPuzzle(puzzleId)
    }

    val uiState by viewModel.uiState.collectAsState()
    val puzzle = uiState.puzzle

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = puzzle?.title ?: "Palavras Cruzadas",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1D1B20),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Timer,
                                contentDescription = null,
                                tint = Color(0xFF6750A4),
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = formatSecondsToMinutes(uiState.elapsedSeconds),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF6750A4)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = Color(0xFFEADDFF),
                                modifier = Modifier.clickable { viewModel.openHintModal() }
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Lightbulb,
                                        contentDescription = null,
                                        tint = Color(0xFF6750A4),
                                        modifier = Modifier.size(12.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "${uiState.hintCredits} Créditos",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF21005D)
                                    )
                                }
                            }
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("btn_game_back")) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color(0xFF1D1B20)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { viewModel.openDefinitionLookup() }, modifier = Modifier.testTag("btn_lookup_definition")) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Pesquisar Definição",
                            tint = Color(0xFF6750A4)
                        )
                    }
                    IconButton(onClick = { viewModel.checkErrors() }, modifier = Modifier.testTag("btn_check_errors")) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Verificar",
                            tint = Color(0xFF10B981)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF7F2FA)
                )
            )
        },
        containerColor = Color(0xFFF7F2FA),
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Active Clue Banner
            ActiveClueBanner(
                activeWord = uiState.activeWord,
                onPrevious = { viewModel.selectPreviousClue() },
                onNext = { viewModel.selectNextClue() }
            )

            // Crossword Grid
            if (puzzle != null) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CrosswordBoardGrid(
                        gridWidth = puzzle.gridWidth,
                        gridHeight = puzzle.gridHeight,
                        boardGrid = uiState.boardGrid,
                        selectedX = uiState.selectedX,
                        selectedY = uiState.selectedY,
                        direction = uiState.direction,
                        activeWord = uiState.activeWord,
                        onCellSelected = { x, y -> viewModel.selectCell(x, y) }
                    )
                }
            }

            // Quick Assist Bar (Verificar, Letra, Palavra, Dica AI, Menu de Dicas)
            AssistToolbar(
                hintCredits = uiState.hintCredits,
                onOpenHintModal = { viewModel.openHintModal() },
                onRevealCell = { viewModel.revealCurrentCell() },
                onRevealWord = { viewModel.revealActiveWord() },
                onRequestSmartHint = { viewModel.requestSmartHint() },
                isLoadingHint = uiState.isLoadingHint
            )

            // Virtual Keyboard
            VirtualKeyboard(
                onKeyClick = { key -> viewModel.onKeyInput(key) },
                onBackspace = { viewModel.onBackspace() },
                onNextClue = { viewModel.selectNextClue() }
            )
        }
    }

    // Feedback Banner Dialog / Alert
    if (uiState.hintFeedbackMessage != null) {
        AlertDialog(
            onDismissRequest = { viewModel.clearFeedbackMessage() },
            title = { Text("Sistema de Dicas", fontWeight = FontWeight.Bold) },
            text = { Text(uiState.hintFeedbackMessage ?: "") },
            confirmButton = {
                TextButton(onClick = { viewModel.clearFeedbackMessage() }) {
                    Text("OK", fontWeight = FontWeight.Bold)
                }
            },
            containerColor = Color(0xFF1E293B),
            titleContentColor = Color.White,
            textContentColor = Color(0xFFE2E8F0)
        )
    }

    // Hint Options Dialog
    if (uiState.isHintModalVisible) {
        HintOptionsDialog(
            hintCredits = uiState.hintCredits,
            onDismiss = { viewModel.dismissHintModal() },
            onRevealLetter = { viewModel.revealCurrentCell() },
            onRevealWord = { viewModel.revealActiveWord() },
            onRequestSmartHint = { viewModel.requestSmartHint() },
            onOpenLookup = { viewModel.openDefinitionLookup() },
            onAddBonus = { viewModel.addBonusCredits(3) }
        )
    }

    // Definition Lookup Dialog (Gemini API Hint Tool)
    if (uiState.isDefinitionLookupVisible) {
        DefinitionLookupDialog(
            query = uiState.searchWordQuery,
            isSearching = uiState.isSearchingDefinition,
            lookupResult = uiState.lookupResult,
            onQueryChange = { viewModel.onSearchWordQueryChanged(it) },
            onSearch = { viewModel.lookupWordDefinition() },
            onDismiss = { viewModel.dismissDefinitionLookup() }
        )
    }

    // Smart Hint Dialog
    if (uiState.smartHintMessage != null) {
        AlertDialog(
            onDismissRequest = { viewModel.clearSmartHintMessage() },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Default.Lightbulb, contentDescription = null, tint = Color(0xFFF59E0B))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Dica Inteligente IA", fontWeight = FontWeight.Bold)
                }
            },
            text = { Text(uiState.smartHintMessage ?: "") },
            confirmButton = {
                TextButton(onClick = { viewModel.clearSmartHintMessage() }) {
                    Text("Entendido", fontWeight = FontWeight.Bold)
                }
            },
            containerColor = Color(0xFF1E293B),
            titleContentColor = Color.White,
            textContentColor = Color(0xFFE2E8F0)
        )
    }

    // Victory Celebration Dialog
    if (uiState.isVictoryDialogVisible) {
        VictoryDialog(
            stars = uiState.starsEarned,
            elapsedSeconds = uiState.elapsedSeconds,
            hintsUsed = uiState.hintsUsed,
            onDismiss = {
                viewModel.dismissVictoryDialog()
                onBack()
            }
        )
    }
}

@Composable
private fun ActiveClueBanner(
    activeWord: com.example.cruzadas.data.models.WordPlacement?,
    onPrevious: () -> Unit,
    onNext: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEADDFF)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 2.dp)
            .border(1.dp, Color(0xFFD0BCFF), RoundedCornerShape(14.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = CircleShape,
                color = Color.White,
                modifier = Modifier
                    .size(28.dp)
                    .clickable { onPrevious() }
                    .testTag("btn_clue_prev")
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.NavigateBefore,
                        contentDescription = "Pista Anterior",
                        tint = Color(0xFF6750A4),
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 6.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (activeWord != null) {
                    val dirText = if (activeWord.direction == "ACROSS") "Horizontal" else "Vertical"
                    val parts = activeWord.word.split(Regex("[#\\s]+")).filter { it.isNotEmpty() }
                    val letterCountText = if (parts.size > 1) {
                        val breakdown = parts.map { it.length }.joinToString("+")
                        "$breakdown (${parts.sumOf { it.length }} LETRAS)"
                    } else {
                        "${activeWord.word.length} LETRAS"
                    }
                    Text(
                        text = "$dirText • ${activeWord.number} ($letterCountText)",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF6750A4)
                    )
                    Text(
                        text = activeWord.clue,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF21005D),
                        textAlign = TextAlign.Center,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                } else {
                    Text(
                        text = "Toque numa célula para ver a pista",
                        fontSize = 12.sp,
                        color = Color(0xFF625B71)
                    )
                }
            }

            Surface(
                shape = CircleShape,
                color = Color.White,
                modifier = Modifier
                    .size(28.dp)
                    .clickable { onNext() }
                    .testTag("btn_clue_next")
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.NavigateNext,
                        contentDescription = "Próxima Pista",
                        tint = Color(0xFF6750A4),
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun AssistToolbar(
    hintCredits: Int,
    onOpenHintModal: () -> Unit,
    onRevealCell: () -> Unit,
    onRevealWord: () -> Unit,
    onRequestSmartHint: () -> Unit,
    isLoadingHint: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF7F2FA))
            .padding(horizontal = 4.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AssistButton(
            icon = Icons.Default.Visibility,
            label = "Letra (-1)",
            onClick = onRevealCell,
            modifier = Modifier.weight(1f).testTag("btn_reveal_letter")
        )
        AssistButton(
            icon = Icons.Default.Lightbulb,
            label = "Palavra (-2)",
            onClick = onRevealWord,
            modifier = Modifier.weight(1f).testTag("btn_reveal_word")
        )
        AssistButton(
            icon = Icons.Default.AutoAwesome,
            label = if (isLoadingHint) "Pensando" else "Dica IA (-1)",
            onClick = onRequestSmartHint,
            isLoading = isLoadingHint,
            accentColor = Color(0xFF6750A4),
            modifier = Modifier.weight(1f).testTag("btn_smart_hint")
        )
        AssistButton(
            icon = Icons.Default.HelpOutline,
            label = "Menu ($hintCredits)",
            onClick = onOpenHintModal,
            accentColor = Color(0xFF10B981),
            modifier = Modifier.weight(1f).testTag("btn_hint_menu")
        )
    }
}

@Composable
private fun HintOptionsDialog(
    hintCredits: Int,
    onDismiss: () -> Unit,
    onRevealLetter: () -> Unit,
    onRevealWord: () -> Unit,
    onRequestSmartHint: () -> Unit,
    onOpenLookup: () -> Unit,
    onAddBonus: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.Lightbulb, contentDescription = null, tint = Color(0xFFF59E0B))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Sistema de Dicas", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        },
        text = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFF334155),
                    modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Créditos Disponíveis:", color = Color(0xFF94A3B8), fontSize = 13.sp)
                        Text("$hintCredits 💡", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    }
                }

                Button(
                    onClick = onRevealLetter,
                    enabled = hintCredits >= 1,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6750A4)),
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp).testTag("btn_dialog_reveal_letter")
                ) {
                    Text("Revelar Letra Actual (1 Crédito)")
                }

                Button(
                    onClick = onRevealWord,
                    enabled = hintCredits >= 2,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6750A4)),
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp).testTag("btn_dialog_reveal_word")
                ) {
                    Text("Revelar Palavra Inteira (2 Créditos)")
                }

                Button(
                    onClick = onRequestSmartHint,
                    enabled = hintCredits >= 1,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7E57C2)),
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp).testTag("btn_dialog_smart_hint")
                ) {
                    Text("Dica Inteligente IA (1 Crédito)")
                }

                Button(
                    onClick = onOpenLookup,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp).testTag("btn_dialog_definition_lookup")
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Pesquisar Definição com Gemini IA 🔍")
                    }
                }

                Button(
                    onClick = onAddBonus,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp).testTag("btn_dialog_add_bonus")
                ) {
                    Text("Obter +3 Créditos de Bónus 🎁", fontWeight = FontWeight.Bold)
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Fechar", fontWeight = FontWeight.Bold)
            }
        },
        containerColor = Color(0xFF1E293B),
        titleContentColor = Color.White,
        textContentColor = Color(0xFFE2E8F0)
    )
}

@Composable
private fun DefinitionLookupDialog(
    query: String,
    isSearching: Boolean,
    lookupResult: com.example.cruzadas.data.api.WordLookupResult?,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = Color(0xFF38BDF8))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Dicionário Gemini IA", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
        },
        text = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Consulte definições e significados em tempo real:",
                    fontSize = 12.sp,
                    color = Color(0xFF94A3B8),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = query,
                        onValueChange = onQueryChange,
                        placeholder = { Text("Palavra a pesquisar...") },
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF38BDF8),
                            unfocusedBorderColor = Color(0xFF475569),
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            focusedContainerColor = Color(0xFF0F172A),
                            unfocusedContainerColor = Color(0xFF0F172A)
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .testTag("input_game_word_lookup")
                    )

                    Button(
                        onClick = onSearch,
                        enabled = !isSearching && query.isNotBlank(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.testTag("btn_game_lookup_search")
                    ) {
                        if (isSearching) {
                            CircularProgressIndicator(modifier = Modifier.size(16.dp), color = Color.White, strokeWidth = 2.dp)
                        } else {
                            Icon(imageVector = Icons.Default.AutoAwesome, contentDescription = "Pesquisar", tint = Color.White, modifier = Modifier.size(16.dp))
                        }
                    }
                }

                if (lookupResult != null) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(1.dp, Color(0xFF334155), RoundedCornerShape(12.dp))
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = lookupResult.word.uppercase(),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = Color(0xFF38BDF8)
                                )
                                Surface(shape = RoundedCornerShape(4.dp), color = Color(0xFF1E293B)) {
                                    Text(
                                        text = lookupResult.category,
                                        fontSize = 10.sp,
                                        color = Color(0xFF94A3B8),
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = lookupResult.definition,
                                fontSize = 13.sp,
                                color = Color(0xFFE2E8F0)
                            )
                            if (lookupResult.example.isNotBlank()) {
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = "Exemplo: \"${lookupResult.example}\"",
                                    fontSize = 11.sp,
                                    color = Color(0xFF94A3B8)
                                )
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Fechar", fontWeight = FontWeight.Bold)
            }
        },
        containerColor = Color(0xFF1E293B),
        titleContentColor = Color.White,
        textContentColor = Color(0xFFE2E8F0)
    )
}

@Composable
private fun AssistButton(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    onClick: () -> Unit,
    isLoading: Boolean = false,
    accentColor: Color = Color(0xFF6750A4),
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        color = Color(0xFFF3EDF7),
        modifier = modifier
            .border(1.dp, Color(0xFFCAC4D0), RoundedCornerShape(10.dp))
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 2.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(13.dp),
                    strokeWidth = 1.5.dp,
                    color = accentColor
                )
            } else {
                Icon(imageVector = icon, contentDescription = null, tint = accentColor, modifier = Modifier.size(13.dp))
            }
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = label,
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1D1B20),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun VictoryDialog(
    stars: Int,
    elapsedSeconds: Long,
    hintsUsed: Int,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = null,
                    tint = Color(0xFF10B981),
                    modifier = Modifier.size(56.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Parabéns!",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Color.White
                )
                Text(
                    text = "Desafio Concluído com Sucesso",
                    fontSize = 13.sp,
                    color = Color(0xFF94A3B8)
                )
            }
        },
        text = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Star Rating
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(vertical = 12.dp)
                ) {
                    for (i in 1..3) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = if (i <= stars) Color(0xFFF59E0B) else Color(0xFF475569),
                            modifier = Modifier.size(36.dp)
                        )
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = formatSecondsToMinutes(elapsedSeconds), fontWeight = FontWeight.Bold, color = Color.White, fontSize = 16.sp)
                        Text(text = "Tempo Total", fontSize = 12.sp, color = Color(0xFF94A3B8))
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "$hintsUsed", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 16.sp)
                        Text(text = "Dicas Usadas", fontSize = 12.sp, color = Color(0xFF94A3B8))
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Continuar", fontWeight = FontWeight.Bold)
            }
        },
        containerColor = Color(0xFF1E293B)
    )
}

private fun formatSecondsToMinutes(seconds: Long): String {
    val mins = seconds / 60
    val secs = seconds % 60
    return String.format("%02d:%02d", mins, secs)
}
