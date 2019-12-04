package dev.tangzero.aoc2019.day03

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class PartTwoTest {
    companion object {

        @JvmStatic
        fun distances() = listOf(
            Arguments.of(listOf(
                "R8,U5,L5,D3",
                "U7,R6,D4,L4"), 30),
            Arguments.of(listOf(
                "R75,D30,R83,U83,L12,D49,R71,U7,L72",
                "U62,R66,U55,R34,D71,R55,D58,R83"), 610),
            Arguments.of(listOf(
                "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51",
                "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"), 410)
        )
    }

    @ParameterizedTest
    @MethodSource("distances")
    fun `should calculate fewest combined steps`(lines: List<String>, expectedSteps: Int) {
        val steps = partTwo(lines)
        assertEquals(expectedSteps, steps)
    }

}
