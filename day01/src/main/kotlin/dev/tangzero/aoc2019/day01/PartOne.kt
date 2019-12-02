package dev.tangzero.aoc2019.day01

fun partOne() {
    println("Part One: the necessary fuel is ${totalFuel()}")
}

fun totalFuel(): Int {
    return ClassLoader.getSystemResourceAsStream("input.txt")!!
        .bufferedReader()
        .lines()
        .mapToInt(String::toInt)
        .map(::calculateNecessaryFuel)
        .sum()

}

fun calculateNecessaryFuel(mass: Int): Int {
    return mass / 3 - 2
}
