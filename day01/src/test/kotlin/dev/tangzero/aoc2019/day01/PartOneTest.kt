package dev.tangzero.aoc2019.day01

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class PartOneTest {
    companion object {

        @JvmStatic
        fun inputs() = listOf(
                Arguments.of(12, 2),
                Arguments.of(14, 2),
                Arguments.of(1969, 654),
                Arguments.of(100756, 33583)
        )
    }

    @ParameterizedTest(name = "Fuel of {0} should be equal to {1}")
    @MethodSource("inputs")
    fun `should calculate the necessary fuel based on mass`(mass: Int, expectedFuel: Int) {
        val fuel = calculateNecessaryFuel(mass)
        assertEquals(expectedFuel, fuel)
    }

}