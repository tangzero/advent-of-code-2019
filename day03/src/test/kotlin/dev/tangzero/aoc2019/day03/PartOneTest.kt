package dev.tangzero.aoc2019.day03

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class PartOneTest {
    companion object {

        @JvmStatic
        fun distances() = listOf(
            Arguments.of("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83", 159)
        )
    }

    @ParameterizedTest
    @MethodSource("distances")
    fun `should calculate the Manhattan distance of the closest intersection of`(
        wireA: String, wireB: String, expectedDistance: Int) {
        val distance = calculateClosestIntersection(createWire(wireA), createWire(wireB))
        assertEquals(expectedDistance, distance)
    }

}
