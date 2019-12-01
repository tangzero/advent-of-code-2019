package dev.tangzero.aoc2019.day01

fun partTwo() {
    println("Part Two: the necessary fuel is ${totalFuelV2()}")
}

fun totalFuelV2(): Int {
    return ClassLoader.getSystemResourceAsStream("input.txt")!!
            .bufferedReader()
            .lines()
            .mapToInt(String::toInt)
            .map(::calculateNecessaryFuelV2)
            .sum()
}

fun calculateNecessaryFuelV2(mass: Int): Int {
    val fuel = mass / 3 - 2
    return if (fuel <= 0) 0 else fuel + calculateNecessaryFuelV2(fuel)
}
