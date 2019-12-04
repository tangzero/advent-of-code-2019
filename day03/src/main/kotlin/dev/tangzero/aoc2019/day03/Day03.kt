package dev.tangzero.aoc2019.day03

fun main() {
    val lines = readLines()

    println("Day 3: Crossed Wires")

    val distance = partOne(lines)
    println("Part One: the Manhattan distance is $distance")

    val steps = partTwo(lines)
    println("Part Two: the fewest combined steps the wires must take to reach are $steps")
}

fun readLines(): List<String> =
    ClassLoader.getSystemResourceAsStream("input.txt")!!
        .bufferedReader()
        .lineSequence()
        .toList()
