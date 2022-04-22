package com.example.androidcalculator.view.atom

import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun InputButton(
    onClick: () -> Unit = {},
    content: @Composable () -> Unit = {},
    backgroundColor: Color = Color(0xD1, 0xD1, 0xD1)
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = Modifier.padding(4.dp),
        backgroundColor = backgroundColor,
    ) {
        content()
    }
}