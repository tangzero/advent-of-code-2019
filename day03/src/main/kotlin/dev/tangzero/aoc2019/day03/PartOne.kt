package dev.tangzero.aoc2019.day03

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun partOne(lines: List<String>): Int {
    val (wireA, wireB) = lines.map(::createWire)
    return wireA.intersections(wireB).map(Point::manhattan).min()!!
}

data class Point(val x: Int, val y: Int) {
    fun manhattan() = abs(x) + abs(y)
    fun isZero() = x == 0 && y == 0
}

data class Segment(val start: Point, val end: Point) {
    fun intersect(other: Segment): Point? {
        if (start.isZero() || other.start.isZero()) {
            return null
        }

        if (start.x == end.x) {
            if ((start.x in min(other.start.x, other.end.x)..max(other.start.x, other.end.x))
                && (other.start.y in min(start.y, end.y)..max(start.y, end.y))) {
                return Point(start.x, other.start.y)
            }
        } else {
            if ((start.y in min(other.start.y, other.end.y)..max(other.start.y, other.end.y))
                && (other.start.x in min(start.x, end.x)..max(start.x, end.x))) {
                return Point(other.start.x, start.y)
            }
        }
        return null
    }
}

data class Wire(val segments: List<Segment>) {
    fun intersections(other: Wire): List<Point> {
        val crosses = mutableListOf<Point>()
        for (segment in segments) {
            for (otherSegment in other.segments) {
                segment.intersect(otherSegment)?.let(crosses::add)
            }
        }
        return crosses
    }
}

fun createWire(input: String): Wire {
    var start = Point(0, 0)
    val points = input.split(",")
        .map { move -> createSegment(start, move).also { segment -> start = segment.end } }
        .distinct()
    return Wire(points)
}

fun createSegment(start: Point, move: String): Segment {
    val dir = move[0]
    val steps = move.substring(1).toInt()
    val end = when (dir) {
        'U' -> Point(start.x, start.y + steps)
        'D' -> Point(start.x, start.y - steps)
        'R' -> Point(start.x + steps, start.y)
        'L' -> Point(start.x - steps, start.y)
        else -> start
    }
    return Segment(start, end)
}
