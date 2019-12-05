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
            Arguments.of(listOf(3, 0, 4, 0, 99), "1"),
            Arguments.of(listOf(1002, 4, 2, 4, 2, 4, 99), "4"),
            Arguments.of(listOf(1002, 4, 2, 4, 2, 4, 99), "4")
        )
    }

    private val out: PrintStream = System.out
    private val buffer: ByteArrayOutputStream = ByteArrayOutputStream()

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
    fun `should run the diagnostic program`(codes: IntCodes, expected: String) {
        process(codes)
        assertEquals(expected, buffer.toString().trim())
    }

}
