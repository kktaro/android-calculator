package com.example.androidcalculator.view.organism

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun NumberDisplay(
    value: String
) {
    Text(
        text = value,
        maxLines = 1,
        textAlign = TextAlign.Center,
        fontSize = 24.sp,
    )
}