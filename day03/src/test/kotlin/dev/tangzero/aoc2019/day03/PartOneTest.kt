package dev.tangzero.aoc2019.day03

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class PartOneTest {
    companion object {

        @JvmStatic
        fun distances() = listOf(
            Arguments.of(listOf(
                "R75,D30,R83,U83,L12,D49,R71,U7,L72",
                "U62,R66,U55,R34,D71,R55,D58,R83"), 159),
            Arguments.of(listOf(
                "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51",
                "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"), 135)
        )
    }

    @ParameterizedTest
    @MethodSource("distances")
    fun `should calculate the Manhattan distance of the closest intersection of`(
        lines: List<String>, expectedDistance: Int) {
        val distance = partOne(lines)
        assertEquals(expectedDistance, distance)
    }

}
