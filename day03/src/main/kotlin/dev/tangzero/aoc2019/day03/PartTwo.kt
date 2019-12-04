package dev.tangzero.aoc2019.day03

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun partTwo(lines: List<String>): Int {
    val (wireA, wireB) = lines.map(::createWire)
    return wireA.intersections(wireB).map { wireA.stepsTo(it) + wireB.stepsTo(it) }.min()!!
}

fun Segment.contains(point: Point) =
    point.x in min(start.x, end.x)..max(start.x, end.x) && point.y in min(start.y, end.y)..max(start.y, end.y)

fun Segment.length() =
    max(abs(end.x - start.x), abs(end.y - start.y))

fun Segment.stepsTo(point: Point) =
    if (point.x == start.x && point.x == end.x) {
        abs(point.y - start.y)
    } else {
        abs(point.x - start.x)
    }

fun Wire.stepsTo(point: Point): Int {
    var steps = 0
    segments.forEach { segment ->
        if (segment.contains(point)) {
            return steps + segment.stepsTo(point)
        }
        steps += segment.length()
    }
    return steps
}

