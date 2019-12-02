package dev.tangzero.aoc2019.day02

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class PartOneTest {
    companion object {

        @JvmStatic
        fun inputs() = listOf(
            Arguments.of(mutableListOf(1, 0, 0, 0, 99), listOf(2, 0, 0, 0, 99)),
            Arguments.of(mutableListOf(2, 3, 0, 3, 99), listOf(2, 3, 0, 6, 99)),
            Arguments.of(mutableListOf(2, 4, 4, 5, 99, 0), listOf(2, 4, 4, 5, 99, 9801)),
            Arguments.of(mutableListOf(1, 1, 1, 4, 99, 5, 6, 0, 99), listOf(30, 1, 1, 4, 2, 5, 6, 0, 99))
        )
    }

    @ParameterizedTest
    @MethodSource("inputs")
    fun `should correctly process the intcode input`(input: IntCodes, expected: IntCodes) {
        process(input)
        assertEquals(expected, input)
    }

}
