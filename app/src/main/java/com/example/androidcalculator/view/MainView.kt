package com.example.androidcalculator.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androidcalculator.const.Constant
import com.example.androidcalculator.view.organism.*
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
            Column {
                Center(
                    modifier = Modifier.weight(1F),
                ) {
                    NumberDisplay(value = viewModel.displayNumber.value)
                }
                Center(
                    modifier = Modifier.weight(2F),
                ) {
                    Row {
                        ClearButton(
                            onClick = { viewModel.onTapClear() },
                            text = "CLEAR",
                        )
                    }
                    Row {
                        NumberButton(
                            onClick = { viewModel.onTapNumber("7") },
                            content = { Text(text = "7") },
                        )
                        NumberButton(
                            onClick = { viewModel.onTapNumber("8") },
                            content = { Text(text = "8") },
                        )
                        NumberButton(
                            onClick = { viewModel.onTapNumber("9") },
                            content = { Text(text = "9") },
                        )
                        OperatorButton(
                            onClick = { viewModel.onTapOperator(MainViewModel.CalculateKind.Divide) },
                            operatorKind = MainViewModel.CalculateKind.Divide,
                            kindState = viewModel.calculateKind.value,
                            content = { Text(text = "÷") },
                        )
                    }
                    Row {
                        NumberButton(
                            onClick = { viewModel.onTapNumber("4") },
                            content = { Text(text = "4") },
                        )
                        NumberButton(
                            onClick = { viewModel.onTapNumber("5") },
                            content = { Text(text = "5") },
                        )
                        NumberButton(
                            onClick = { viewModel.onTapNumber("6") },
                            content = { Text(text = "6") },
                        )
                        OperatorButton(
                            onClick = { viewModel.onTapOperator(MainViewModel.CalculateKind.Times) },
                            operatorKind = MainViewModel.CalculateKind.Times,
                            kindState = viewModel.calculateKind.value,
                            content = { Text(text = "×") },
                        )
                    }
                    Row {
                        NumberButton(
                            onClick = { viewModel.onTapNumber("1") },
                            content = { Text(text = "1") },
                        )
                        NumberButton(
                            onClick = { viewModel.onTapNumber("2") },
                            content = { Text(text = "2") },
                        )
                        NumberButton(
                            onClick = { viewModel.onTapNumber("3") },
                            content = { Text(text = "3") },
                        )
                        OperatorButton(
                            onClick = { viewModel.onTapOperator(MainViewModel.CalculateKind.Minus) },
                            operatorKind = MainViewModel.CalculateKind.Minus,
                            kindState = viewModel.calculateKind.value,
                            content = { Text(text = "-") },
                        )
                    }
                    Row {
                        SpecialButton(
                            onClick = { viewModel.onTapBackspace() },
                            content = { Text(text = "←") },
                        )
                        NumberButton(
                            onClick = { viewModel.onTapNumber("0") },
                            content = { Text(text = "0") },
                        )
                        OperatorButton(
                            onClick = { viewModel.onTapEqual() },
                            kindState = viewModel.calculateKind.value,
                            content = { Text(text = "=") },
                        )
                        OperatorButton(
                            onClick = { viewModel.onTapOperator(MainViewModel.CalculateKind.Plus) },
                            operatorKind = MainViewModel.CalculateKind.Plus,
                            kindState = viewModel.calculateKind.value,
                            content = { Text(text = "+") },
                        )
                    }
                }
            }
        }
    }
}