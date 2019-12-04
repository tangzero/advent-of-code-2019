package dev.tangzero.aoc2019.day03

fun partTwo(lines: List<String>): Int {
//    val (wireA, wireB) = lines.map(::createWire)
//    return intersections(wireA, wireB).map { wireA.stepsTo(it) + wireB.stepsTo(it) }.min()!!
    return 0
}

operator fun Point.minus(other: Point) = Point(x - other.x, y - other.y)

//fun Wire.stepsTo(destination: Point) = points.indexOf(destination)

