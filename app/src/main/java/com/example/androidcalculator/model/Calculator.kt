package com.example.androidcalculator.model

import kotlin.math.sign

@JvmInline
value class CalculateData(val value: Long)

/**
 * 計算値を保持するクラス
 * 値として、-999999999999999999 ~ 999999999999999999をとる(18桁)
 * 計算結果が上記を外れた場合は最小値か最大値を保持する
 * 0除算時は値を変更しない
 */
object Calculator {
    var calculateData = CalculateData(0)
        private set

    fun add(value: Long) {
        val result = calculateData.value + value
        calculateData = CalculateData(getCalculateValue(result))
    }

    fun sub(value: Long) {
        val result = calculateData.value - value
        calculateData = CalculateData(getCalculateValue(result))
    }

    fun multiple(value: Long) {
        val result = calculateData.value * value
        calculateData = CalculateData(getCalculateValue(result))
    }

    fun divide(value: Long) {
        if (value == 0L) return
        val result = calculateData.value / value
        calculateData = CalculateData(getCalculateValue(result))
    }

    fun clear() {
        calculateData = CalculateData(0)
    }

    private fun isWithinRange(value: Long): Boolean =
        -999999999999999999 < value && value < 999999999999999999

    private fun getLimit(value: Long): Long =
        if(value.sign < 0) -999999999999999999 else 999999999999999999

    private fun getCalculateValue(value: Long): Long =
        if(isWithinRange(value)) value else getLimit(value)
}