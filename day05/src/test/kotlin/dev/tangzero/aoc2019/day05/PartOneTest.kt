package dev.tangzero.aoc2019.day05

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

class PartOneTest {
    companion object {

        @JvmStatic
        fun codes() = listOf(
            Arguments.of(listOf(3, 0, 4, 0, 99), 88, "88"),
            Arguments.of(listOf(1002, 4, 2, 4, 2, 4, 99), 1, "4"),
            Arguments.of(listOf(101, 4, 3, 7, 4, 7, 99, 50), 1, "11")
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
        PartOne.process(codes, input)
        assertEquals(output, buffer.toString().trim())
    }

}
