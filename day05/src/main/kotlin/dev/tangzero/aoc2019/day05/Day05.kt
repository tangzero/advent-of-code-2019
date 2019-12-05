package dev.tangzero.aoc2019.day05

typealias IntCodes = MutableList<Int>

fun main() {
    val codes = readIntCodes()

    println("Day 5: Sunny with a Chance of Asteroids")

    println("Part One: running the diagnostic program...")
    PartOne.process(codes.toMutableList(), input = 1)

    println("Part Two: running the diagnostic program again...")
    PartTwo.process(codes.toMutableList(), input = 5)
}

fun readIntCodes(): IntCodes {
    return ClassLoader.getSystemResourceAsStream("input.txt")!!
        .bufferedReader()
        .readLine()
        .split(",")
        .map(String::toInt)
        .toMutableList()
}
