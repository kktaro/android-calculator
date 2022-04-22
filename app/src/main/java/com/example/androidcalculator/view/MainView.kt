package com.example.androidcalculator.view

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidcalculator.const.Constant
import com.example.androidcalculator.view.atom.InputButton
import com.example.androidcalculator.view.organism.ClearButton
import com.example.androidcalculator.view.organism.NumberButton
import com.example.androidcalculator.view.organism.OperatorButton
import com.example.androidcalculator.view.organism.SpecialButton
import com.example.androidcalculator.view.template.Center
import com.example.androidcalculator.viewmodel.MainViewModel

@Composable
fun MainView(viewModel: MainViewModel) {
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar {
                    Text(text = Constant.TITLE)
                }
            }
        ) {
            Center {
                Row {
                    ClearButton(text = "CLEAR")
                }
                Row {
                    NumberButton(
                        onClick = {viewModel.onTapNumber("7")},
                        content = {Text(text = "7")},
                    )
                    NumberButton(
                        onClick = {viewModel.onTapNumber("8")},
                        content = {Text(text = "8")},
                    )
                    NumberButton(
                        onClick = {viewModel.onTapNumber("9")},
                        content = {Text(text = "9")},
                    )
                    OperatorButton(
                        onClick = {viewModel.onTapOperator(MainViewModel.CalculateKind.Divide)},
                        content = {Text(text = "÷")},
                    )
                }
                Row {
                    NumberButton(
                        onClick = {viewModel.onTapNumber("4")},
                        content = {Text(text = "4")},
                    )
                    NumberButton(
                        onClick = {viewModel.onTapNumber("5")},
                        content = {Text(text = "5")},
                    )
                    NumberButton(
                        onClick = {viewModel.onTapNumber("6")},
                        content = {Text(text = "6")},
                    )
                    OperatorButton(
                        onClick = {viewModel.onTapOperator(MainViewModel.CalculateKind.Times)},
                        content = {Text(text = "×")},
                    )
                }
                Row {
                    NumberButton(
                        onClick = {viewModel.onTapNumber("1")},
                        content = {Text(text = "1")},
                    )
                    NumberButton(
                        onClick = {viewModel.onTapNumber("2")},
                        content = {Text(text = "2")},
                    )
                    NumberButton(
                        onClick = {viewModel.onTapNumber("3")},
                        content = {Text(text = "3")},
                    )
                    OperatorButton(
                        onClick = {viewModel.onTapOperator(MainViewModel.CalculateKind.Minus)},
                        content = {Text(text = "-")},
                    )
                }
                Row {
                    SpecialButton(
                        onClick = {viewModel.onTapBackspace()},
                        content = {Text(text = "←")},
                    )
                    NumberButton(
                        onClick = {viewModel.onTapNumber("0")},
                        content = {Text(text = "0")},
                    )
                    OperatorButton(
                        onClick = {viewModel.onTapEqual()},
                        content = {Text(text = "=")},
                    )
                    OperatorButton(
                        onClick = {viewModel.onTapOperator(MainViewModel.CalculateKind.Plus)},
                        content = {Text(text = "+")},
                    )
                }
            }
        }
    }
}