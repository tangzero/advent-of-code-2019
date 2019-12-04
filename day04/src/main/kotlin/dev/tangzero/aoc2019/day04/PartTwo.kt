package dev.tangzero.aoc2019.day04

fun partTwo(range: IntRange): Int {
    return range.map(Int::toString).filter(String::stillAValidPassword).count()
}

fun String.stillAValidPassword() =
    isAValidPassword() && hasEvenRepetitions()

private fun String.hasEvenRepetitions() =
    this.split("")
        .filter(String::isNotBlank)
        .groupBy { it }
        .values
        .count { it.size == 2 } >= 1
