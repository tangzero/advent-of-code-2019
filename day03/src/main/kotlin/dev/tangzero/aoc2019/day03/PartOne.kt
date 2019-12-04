package dev.tangzero.aoc2019.day03

import kotlin.math.abs

fun partOne(lines: List<String>): Int {
    val (wireA, wireB) = lines.map(::createWire)
    return intersections(wireA, wireB).map(Point::manhattan).min()!!
}

data class Point(val x: Int, val y: Int) {
    fun manhattan() = abs(x) + abs(y)
}

data class Wire(val points: List<Point>)

fun intersections(wireA: Wire, wireB: Wire): List<Point> {
    val crosses = mutableListOf<Point>()
    for (pA in wireA.points) {
        for (pB in wireB.points) {
            if (pA == pB && pA != Point(0, 0)) {
                crosses.add(pA)
            }
        }
    }
    return crosses
}

fun createWire(input: String): Wire {
    var start = Point(0, 0)
    val points = input.split(",")
        .map { move -> createPoints(start, move).also { points -> start = points.last() } }
        .reduce { acc, list -> acc + list }
        .distinct()
    return Wire(points)
}

fun createPoints(start: Point, move: String): List<Point> {
    val dir = move[0]
    val steps = move.substring(1).toInt()
    return when (dir) {
        'U' -> (start.y.rangeTo(start.y + steps)).map { Point(start.x, it) }
        'D' -> (start.y.downTo(start.y - steps)).map { Point(start.x, it) }
        'R' -> (start.x.rangeTo(start.x + steps)).map { Point(it, start.y) }
        'L' -> (start.x.downTo(start.x - steps)).map { Point(it, start.y) }
        else -> emptyList()
    }
}
