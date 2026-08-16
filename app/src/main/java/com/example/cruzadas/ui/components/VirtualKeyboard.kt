package com.example.cruzadas.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Backspace
import androidx.compose.material.icons.automirrored.filled.NavigateNext
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VirtualKeyboard(
    onKeyClick: (String) -> Unit,
    onBackspace: () -> Unit,
    onNextClue: () -> Unit,
    modifier: Modifier = Modifier
) {
    val row1 = listOf("Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P")
    val row2 = listOf("A", "S", "D", "F", "G", "H", "J", "K", "L", "Ç")
    val row3 = listOf("Z", "X", "C", "V", "B", "N", "M")

    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Color(0xFFF3EDF7),
        tonalElevation = 2.dp
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 6.dp, horizontal = 4.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            // Row 1
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                for (key in row1) {
                    KeyButton(text = key, onClick = { onKeyClick(key) }, modifier = Modifier.weight(1f))
                }
            }

            // Row 2
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                for (key in row2) {
                    KeyButton(text = key, onClick = { onKeyClick(key) }, modifier = Modifier.weight(1f))
                }
            }

            // Row 3 (with Backspace and Next Word buttons)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(3.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Next Word Button
                Box(
                    modifier = Modifier
                        .weight(1.3f)
                        .height(44.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFEADDFF))
                        .border(1.dp, Color(0xFFCAC4D0), RoundedCornerShape(8.dp))
                        .clickable { onNextClue() }
                        .testTag("key_next_clue"),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.NavigateNext,
                        contentDescription = "Próxima Pista",
                        tint = Color(0xFF21005D)
                    )
                }

                for (key in row3) {
                    KeyButton(text = key, onClick = { onKeyClick(key) }, modifier = Modifier.weight(1f))
                }

                // Backspace Button
                Box(
                    modifier = Modifier
                        .weight(1.3f)
                        .height(44.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFEADDFF))
                        .border(1.dp, Color(0xFFCAC4D0), RoundedCornerShape(8.dp))
                        .clickable { onBackspace() }
                        .testTag("key_backspace"),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Backspace,
                        contentDescription = "Apagar",
                        tint = Color(0xFF21005D)
                    )
                }
            }
        }
    }
}

@Composable
private fun KeyButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(44.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .border(1.dp, Color(0xFFCAC4D0), RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .testTag("key_$text"),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1D1B20)
        )
    }
}
