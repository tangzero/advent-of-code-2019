package dev.tangzero.aoc2019.day02

typealias IntCodes = MutableList<Int>

fun main() {
    println("Day 2: 1202 Program Alarm")
    partOne()
    partTwo()
}

fun intCodes(): IntCodes {
    return ClassLoader.getSystemResourceAsStream("input.txt")!!
        .bufferedReader()
        .readLine()
        .split(",")
        .map(String::toInt)
        .toMutableList()
}
