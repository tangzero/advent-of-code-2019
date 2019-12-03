package dev.tangzero.aoc2019.day03

import java.util.stream.Collectors
import kotlin.math.abs

fun partOne() {
    val (wireA, wireB) = readWires()
    val distance = calculateClosestIntersection(wireA, wireB)
    println("Part One: the Manhattan distance is $distance")
}

data class Point(val x: Int, val y: Int) {
    fun manhattan() = abs(x) + abs(y)
}

data class Wire(val points: List<Point>)

fun calculateClosestIntersection(wireA: Wire, wireB: Wire): Int {
    val crosses = mutableListOf<Point>()

    for (pA in wireA.points) {
        for (pB in wireB.points) {
            if (pA == pB && pA != Point(0, 0)) {
                crosses.add(pA)
            }
        }
    }

    return crosses.map(Point::manhattan).min()!!
}

fun readWires(): List<Wire> =
    ClassLoader.getSystemResourceAsStream("input.txt")!!
        .bufferedReader()
        .lines()
        .map { createWire(it) }
        .collect(Collectors.toList())

fun createWire(input: String): Wire {
    var start = Point(0, 0)
    val points = input.split(",")
        .map { move -> createPoints(start, move).also { points -> start = points.last() } }
        .reduce { acc, list -> acc + list }
    return Wire(points)
}

fun createPoints(start: Point, move: String): List<Point> {
    val dir = move[0]
    val amount = move.substring(1).toInt()
    return when (dir) {
        'U' -> (start.y.rangeTo(start.y + amount)).map { Point(start.x, it) }
        'D' -> (start.y.downTo(start.y - amount)).map { Point(start.x, it) }
        'R' -> (start.x.rangeTo(start.x + amount)).map { Point(it, start.y) }
        'L' -> (start.x.downTo(start.x - amount)).map { Point(it, start.y) }
        else -> emptyList()
    }
}
