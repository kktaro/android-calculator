package com.example.androidcalculator.view.organism

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.androidcalculator.view.atom.InputButton
import com.example.androidcalculator.viewmodel.MainViewModel

@Composable
fun OperatorButton(
    onClick: () -> Unit = {},
    operatorKind: MainViewModel.CalculateKind? = null,
    kindState: MainViewModel.CalculateKind,
    content: @Composable () -> Unit = {},
) {
    InputButton(
        backgroundColor = if(operatorKind == kindState) Color(0xEE, 0xFA, 0xA2)
                            else Color(0xA2,0xFA,0xDA),
        onClick = onClick,
        content = content,
    )
}