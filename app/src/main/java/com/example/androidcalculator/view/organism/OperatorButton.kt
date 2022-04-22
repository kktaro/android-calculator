package com.example.androidcalculator.view.organism

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.androidcalculator.view.atom.InputButton

@Composable
fun OperatorButton(
    onClick: () -> Unit = {},
    content: @Composable () -> Unit = {},
) {
    InputButton(
        backgroundColor = Color(0xA2,0xFA,0xDA),
        onClick = onClick,
        content = content,
    )
}