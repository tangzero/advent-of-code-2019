package dev.tangzero.aoc2019.day01

fun partOne() {
    println("Part One: the necessary fuel is ${totalFuel()}")
}

fun totalFuel(): Int {
    val input = ClassLoader.getSystemResourceAsStream("input.txt")!!
    return input
            .bufferedReader()
            .lines()
            .mapToInt(String::toInt)
            .map(::calculateNecessaryFuel)
            .sum()
}

fun calculateNecessaryFuel(mass: Int): Int {
    return mass / 3 - 2
}
