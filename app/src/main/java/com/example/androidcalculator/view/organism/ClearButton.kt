package com.example.androidcalculator.view.organism

import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ClearButton(
    onClick: () -> Unit = {},
    text: String,
) {
    ExtendedFloatingActionButton(
        onClick = onClick,
        icon = {Icon(Icons.Rounded.Clear, contentDescription = "Clear")},
        text = {Text(text = text)},
        backgroundColor = Color(0xF0,0xB5,0x7F),
    )
}