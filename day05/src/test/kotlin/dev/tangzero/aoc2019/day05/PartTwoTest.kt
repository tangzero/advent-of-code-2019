package dev.tangzero.aoc2019.day05

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

class PartTwoTest {
    companion object {

        @JvmStatic
        fun codes() = listOf(
            Arguments.of(listOf(3, 0, 4, 0, 99), 88, "88"),
            Arguments.of(listOf(1002, 4, 2, 4, 2, 4, 99), 1, "4"),
            Arguments.of(listOf(101, 4, 3, 7, 4, 7, 99, 50), 1, "11"),
            Arguments.of(listOf(3, 9, 8, 9, 10, 9, 4, 9, 99, -1, 8), 8, "1"),
            Arguments.of(listOf(3, 9, 8, 9, 10, 9, 4, 9, 99, -1, 8), 9, "0"),
            Arguments.of(listOf(3, 9, 8, 9, 10, 9, 4, 9, 99, -1, 8), 9, "0"),
            Arguments.of(listOf(3, 12, 6, 12, 15, 1, 13, 14, 13, 4, 13, 99, -1, 0, 1, 9), 0, "0"),
            Arguments.of(listOf(3, 12, 6, 12, 15, 1, 13, 14, 13, 4, 13, 99, -1, 0, 1, 9), 2, "1"),
            Arguments.of(listOf(3, 3, 1105, -1, 9, 1101, 0, 0, 12, 4, 12, 99, 1), 0, "0"),
            Arguments.of(listOf(3, 3, 1105, -1, 9, 1101, 0, 0, 12, 4, 12, 99, 1), 2, "1"),
            Arguments.of(listOf(3, 21, 1008, 21, 8, 20, 1005, 20, 22, 107, 8, 21, 20, 1006, 20, 31,
                1106, 0, 36, 98, 0, 0, 1002, 21, 125, 20, 4, 20, 1105, 1, 46, 104,
                999, 1105, 1, 46, 1101, 1000, 1, 20, 4, 20, 1105, 1, 46, 98, 99), 7, "999"),
            Arguments.of(listOf(3, 21, 1008, 21, 8, 20, 1005, 20, 22, 107, 8, 21, 20, 1006, 20, 31,
                1106, 0, 36, 98, 0, 0, 1002, 21, 125, 20, 4, 20, 1105, 1, 46, 104,
                999, 1105, 1, 46, 1101, 1000, 1, 20, 4, 20, 1105, 1, 46, 98, 99), 8, "1000"),
            Arguments.of(listOf(3, 21, 1008, 21, 8, 20, 1005, 20, 22, 107, 8, 21, 20, 1006, 20, 31,
                1106, 0, 36, 98, 0, 0, 1002, 21, 125, 20, 4, 20, 1105, 1, 46, 104,
                999, 1105, 1, 46, 1101, 1000, 1, 20, 4, 20, 1105, 1, 46, 98, 99), 9, "1001")
        )
    }

    private val out = System.out
    private val buffer = ByteArrayOutputStream()

    @BeforeEach
    fun setup() {
        System.setOut(PrintStream(buffer))
    }

    @AfterEach
    fun cleanup() {
        buffer.reset()
        System.setOut(out)
    }

    @ParameterizedTest
    @MethodSource("codes")
    fun `should run the diagnostic program`(codes: IntCodes, input: Int, output: String) {
        PartTwo.process(codes, input)
        assertEquals(output, buffer.toString().trim())
    }

}
