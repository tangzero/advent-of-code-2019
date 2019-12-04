package dev.tangzero.aoc2019.day04

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class PartTwoTest {
    companion object {

        @JvmStatic
        fun passwords() = listOf(
            Arguments.of("122345", true),
            Arguments.of("111123", false),
            Arguments.of("133679", true),
            Arguments.of("111111", false),
            Arguments.of("223450", false),
            Arguments.of("123789", false),
            Arguments.of("112233", true),
            Arguments.of("123444", false),
            Arguments.of("111122", true),
            Arguments.of("111223", true)
        )
    }

    @ParameterizedTest(name = "{0} is valid: {1}")
    @MethodSource("passwords")
    fun `should ensure valid passwords`(password: String, valid: Boolean) {
        assertEquals(valid, password.stillAValidPassword())
    }

}
