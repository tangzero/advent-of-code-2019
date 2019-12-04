package dev.tangzero.aoc2019.day04

fun main() {
    val range = readRange()

    println("Day 4: Secure Container")
    println("Part One: ${partOne(range)} different passwords")
    println("Part Two: ${partTwo(range)} different passwords")
}

fun readRange(): IntRange {
    val (start, end) = ClassLoader.getSystemResourceAsStream("input.txt")!!
        .bufferedReader()
        .readLine()!!
        .split("-")
        .map(String::toInt)
    return start..end
}
