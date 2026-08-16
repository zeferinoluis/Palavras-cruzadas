package com.example.cruzadas.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cruzadas.data.models.WordPlacement
import com.example.cruzadas.data.viewmodel.BoardCell
import com.example.cruzadas.data.viewmodel.CellCheckStatus
import com.example.cruzadas.data.viewmodel.WordDirection

@Composable
fun CrosswordBoardGrid(
    gridWidth: Int,
    gridHeight: Int,
    boardGrid: Map<Pair<Int, Int>, BoardCell>,
    selectedX: Int,
    selectedY: Int,
    direction: WordDirection,
    activeWord: WordPlacement?,
    onCellSelected: (Int, Int) -> Unit,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val maxAvailableWidth = (maxWidth - 8.dp).coerceAtLeast(100.dp)
        val maxAvailableHeight = (maxHeight - 8.dp).coerceAtLeast(100.dp)

        val cellW = maxAvailableWidth / gridWidth.coerceAtLeast(1)
        val cellH = maxAvailableHeight / gridHeight.coerceAtLeast(1)

        val cellSize = minOf(cellW, cellH).coerceIn(16.dp, 48.dp)

        val scrollStateVert = rememberScrollState()
        val scrollStateHoriz = rememberScrollState()

        Column(
            modifier = Modifier
                .width(cellSize * gridWidth)
                .background(Color(0xFFCAC4D0), RoundedCornerShape(12.dp))
                .padding(2.dp)
                .verticalScroll(scrollStateVert)
                .horizontalScroll(scrollStateHoriz)
        ) {
            for (y in 0 until gridHeight) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    for (x in 0 until gridWidth) {
                        val key = Pair(x, y)
                        val cell = boardGrid[key] ?: BoardCell(x, y, isBlocked = true)

                        val isSelected = x == selectedX && y == selectedY
                        val isInActiveWord = isCellInWord(x, y, activeWord)

                        CrosswordCellItem(
                            cell = cell,
                            isSelected = isSelected,
                            isInActiveWord = isInActiveWord,
                            cellSize = cellSize,
                            onClick = { onCellSelected(x, y) },
                            modifier = Modifier.testTag("cell_${x}_${y}")
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CrosswordCellItem(
    cell: BoardCell,
    isSelected: Boolean,
    isInActiveWord: Boolean,
    cellSize: androidx.compose.ui.unit.Dp,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (cell.isBlocked) {
        // Blocked dark cell
        Box(
            modifier = modifier
                .size(cellSize)
                .background(Color(0xFF1D1B20))
                .border(0.5.dp, Color(0xFFCAC4D0))
        )
        return
    }

    val isIncorrect = cell.checkStatus == CellCheckStatus.INCORRECT ||
            (cell.userChar.isNotEmpty() && !cell.isRevealed && cell.userChar.first() != cell.correctChar)

    // Playable cell background colors
    val backgroundColor = when {
        cell.checkStatus == CellCheckStatus.CORRECT -> Color(0xFF10B981) // Emerald Green
        isIncorrect -> Color(0xFFFEE2E2) // Soft Rose/Red background for wrong letter
        isSelected -> Color(0xFFEADDFF) // M3 Lavender Highlight
        isInActiveWord -> Color(0xFFEADDFF).copy(alpha = 0.45f) // Soft active word highlight
        else -> Color.White // Crisp white
    }

    val textColor = when {
        cell.checkStatus == CellCheckStatus.CORRECT -> Color.White
        isIncorrect -> Color(0xFFDC2626) // Vivid Red text for wrong letter
        isSelected || isInActiveWord -> Color(0xFF21005D)
        else -> Color(0xFF1D1B20)
    }

    val borderColor = when {
        isSelected -> Color(0xFF6750A4)
        isIncorrect -> Color(0xFFEF4444) // Red border for incorrect cells
        else -> Color(0xFFCAC4D0)
    }

    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .size(cellSize)
            .background(backgroundColor)
            .border(
                width = if (isSelected || isIncorrect) 2.dp else 0.5.dp,
                color = borderColor
            )
            .clickable(interactionSource = interactionSource, indication = null) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        // Number badge in top-left
        if (cell.startNumber != null) {
            val numFontSize = when {
                cellSize < 22.dp -> 6.sp
                cellSize < 28.dp -> 7.sp
                else -> 8.sp
            }
            val numColor = when {
                cell.checkStatus == CellCheckStatus.CORRECT -> Color.White.copy(alpha = 0.9f)
                isIncorrect -> Color(0xFF991B1B)
                else -> Color(0xFF625B71)
            }
            Text(
                text = cell.startNumber.toString(),
                fontSize = numFontSize,
                fontWeight = FontWeight.Bold,
                color = numColor,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 1.dp, top = 0.dp)
            )
        }

        // Entered letter
        if (cell.userChar.isNotEmpty()) {
            Text(
                text = cell.userChar.uppercase(),
                fontSize = when {
                    cellSize < 22.dp -> 9.sp
                    cellSize < 28.dp -> 11.sp
                    cellSize < 34.dp -> 13.sp
                    else -> 17.sp
                },
                fontWeight = FontWeight.Bold,
                color = textColor,
                textAlign = TextAlign.Center
            )
        }
    }
}

private fun isCellInWord(x: Int, y: Int, word: WordPlacement?): Boolean {
    if (word == null) return false
    val inRange = if (word.direction == "ACROSS") {
        y == word.startY && x in word.startX until (word.startX + word.word.length)
    } else {
        x == word.startX && y in word.startY until (word.startY + word.word.length)
    }
    if (!inRange) return false
    val idx = if (word.direction == "ACROSS") x - word.startX else y - word.startY
    return idx in word.word.indices && word.word[idx] != '#' && word.word[idx] != ' '
}
