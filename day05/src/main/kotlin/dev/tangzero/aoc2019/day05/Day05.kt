package dev.tangzero.aoc2019.day05

typealias IntCodes = MutableList<Int>

fun main() {
    val codes = readIntCodes()

    println("Day 5: Sunny with a Chance of Asteroids")
    println("Part One: running the diagnostic program...")
    partOne(codes)
}

fun readIntCodes(): IntCodes {
    return ClassLoader.getSystemResourceAsStream("input.txt")!!
        .bufferedReader()
        .readLine()
        .split(",")
        .map(String::toInt)
        .toMutableList()
}
