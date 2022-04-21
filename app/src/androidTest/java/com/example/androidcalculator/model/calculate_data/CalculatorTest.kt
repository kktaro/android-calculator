package com.example.androidcalculator.model.calculate_data

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CalculatorTest {
    private val calculator = Calculator

    @Before
    fun setUp() {
        calculator.clear()
    }

    @Test
    fun `リセット`() {
        assertEquals(calculator.calculateData.value, 0)

        calculator.add(100)
        calculator.clear()
        assertEquals(calculator.calculateData.value, 0)

        calculator.add(999999999999999999)
        calculator.clear()
        assertEquals(calculator.calculateData.value, 0)

        calculator.sub(100)
        calculator.clear()
        assertEquals(calculator.calculateData.value, 0)

        calculator.sub(999999999999999999)
        calculator.clear()
        assertEquals(calculator.calculateData.value, 0)
    }

    @Test
    fun `加算`() {
        assertEquals(calculator.calculateData.value, 0)

        calculator.add(100)
        assertEquals(calculator.calculateData.value, 100)

        calculator.add(-50)
        assertEquals(calculator.calculateData.value, 50)

        calculator.add(-100)
        assertEquals(calculator.calculateData.value, -50)
    }

    @Test
    fun `減算`() {
        assertEquals(calculator.calculateData.value, 0)

        calculator.sub(100)
        assertEquals(calculator.calculateData.value, -100)

        calculator.sub(-50)
        assertEquals(calculator.calculateData.value, -50)

        calculator.sub(-100)
        assertEquals(calculator.calculateData.value, 50)
    }

    @Test
    fun `乗算`() {
        assertEquals(calculator.calculateData.value, 0)

        calculator.multiple(100)
        assertEquals(calculator.calculateData.value, 0)

        calculator.add(1)
        calculator.multiple(1)
        assertEquals(calculator.calculateData.value, 1)

        calculator.multiple(100)
        assertEquals(calculator.calculateData.value, 100)

        calculator.multiple(-100)
        assertEquals(calculator.calculateData.value, -10000)
    }

    @Test
    fun `除算`() {
        assertEquals(calculator.calculateData.value, 0)

        calculator.divide(0)
        assertEquals(calculator.calculateData.value, 0)

        calculator.add(10000)
        calculator.divide(1)
        assertEquals(calculator.calculateData.value, 10000)

        calculator.divide(1000)
        assertEquals(calculator.calculateData.value, 10)

        calculator.divide(20)
        assertEquals(calculator.calculateData.value, 0)

        calculator.add(10)
        calculator.divide(-3)
        assertEquals(calculator.calculateData.value, -3)

        calculator.divide(2)
        assertEquals(calculator.calculateData.value, -1)
    }

    @Test
    fun `境界値`() {
        assertEquals(calculator.calculateData.value, 0)

        calculator.add(999999999999999999)
        assertEquals(calculator.calculateData.value, 999999999999999999)

        calculator.add(1)
        assertEquals(calculator.calculateData.value, 999999999999999999)

        calculator.clear()
        calculator.add(1000000000000000000)
        assertEquals(calculator.calculateData.value, 999999999999999999)

        calculator.clear()
        calculator.sub(999999999999999999)
        assertEquals(calculator.calculateData.value, -999999999999999999)

        calculator.sub(1)
        assertEquals(calculator.calculateData.value, -999999999999999999)

        calculator.clear()
        calculator.sub(1000000000000000000)
        assertEquals(calculator.calculateData.value, -999999999999999999)

        calculator.add(5000000000000000000)
        assertEquals(calculator.calculateData.value, 999999999999999999)

        calculator.sub(5000000000000000000)
        assertEquals(calculator.calculateData.value, -999999999999999999)
    }
}