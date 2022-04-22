package com.example.androidcalculator.view.organism

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.androidcalculator.view.atom.InputButton

@Composable
fun NumberButton(
    onClick: () -> Unit = {},
    content: @Composable () -> Unit = {},
) {
    InputButton(
        backgroundColor = Color(0xD1,0xD1,0xD1),
        onClick = onClick,
        content = content,
    )
}