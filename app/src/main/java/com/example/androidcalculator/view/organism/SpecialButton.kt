package com.example.androidcalculator.view.organism

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.androidcalculator.view.atom.InputButton

@Composable
fun SpecialButton(
    onClick: () -> Unit = {},
    content: @Composable () -> Unit = {},
) {
    InputButton(
        backgroundColor = Color(0xF0,0xB5,0x7F),
        onClick = onClick,
        content = content,
    )
}