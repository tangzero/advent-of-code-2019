package dev.tangzero.aoc2019.day02

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PartTwoTest {

    @Test
    fun `should correctly calculate de correct noun and verb of intcode input`() {
        assertEquals(8976, processV2(intCodes()))
    }

}
