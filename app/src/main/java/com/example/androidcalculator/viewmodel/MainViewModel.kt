package com.example.androidcalculator.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androidcalculator.model.Calculator

class MainViewModel : ViewModel() {
    private val calculator = Calculator

    init {

    }

    /**
     * 画面に表示する値
     */
    val displayNumber = mutableStateOf<String>("0")

    /**
     * 初期状態から数値を入力したかどうか
     */
    private var isFirstInput = true

    private var inputMode: InputMode = InputMode.Insert

    /**
     * 計算を行う種別
     */
    val calculateKind = mutableStateOf<CalculateKind>(CalculateKind.None)

    fun onTapNumber(value: String) {
        val currentDisplay = if(inputMode == InputMode.Insert) displayNumber.value else ""
        val displayLength = currentDisplay
            .replace(",", "")
            .replace("-", "")
            .length
        if (18 <= displayLength) return

        displayNumber.value = getFormattedNumber(getLongValue(currentDisplay + value))
        inputMode = InputMode.Insert
    }

    fun onTapOperator(kind: CalculateKind) {
        if (isFirstInput) {
            calculator.add(getLongValue(displayNumber.value))
            isFirstInput = false
        }
        calculateKind.value = kind
        inputMode = InputMode.Override
    }

    fun onTapEqual() {
        calculate()
        calculateKind.value = CalculateKind.None
        inputMode = InputMode.Override
    }

    fun onTapClear() {
        displayNumber.value = "0"
        isFirstInput = true
        calculateKind.value = CalculateKind.None
        calculator.clear()
    }

    fun onTapBackspace() {
        if (inputMode != InputMode.Insert) return
        val result = getFormattedNumber(getLongValue(displayNumber.value.dropLast(1)))
        displayNumber.value = result.ifEmpty{"0"}
    }

    private fun calculate() {
        val value = getLongValue(displayNumber.value)

        when(calculateKind.value) {
            CalculateKind.Plus ->
                calculator.add(value)
            CalculateKind.Minus ->
                calculator.sub(value)
            CalculateKind.Times ->
                calculator.multiple(value)
            CalculateKind.Divide ->
                calculator.divide(value)
            else -> {}
        }
        displayNumber.value = getFormattedNumber(calculator.calculateData.value)
    }

    sealed class CalculateKind {
        object Plus: CalculateKind()
        object Minus: CalculateKind()
        object Times: CalculateKind()
        object Divide: CalculateKind()
        object None: CalculateKind()
    }

    private sealed class InputMode {
        object Override: InputMode()
        object Insert: InputMode()
    }

    private fun getLongValue(value: String): Long =
        value.replace(",", "").toLongOrNull() ?: 0

    private fun getFormattedNumber(value: Long): String = "%,d".format(value)
}