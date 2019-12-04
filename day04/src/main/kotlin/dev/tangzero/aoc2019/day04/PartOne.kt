package dev.tangzero.aoc2019.day04

fun partOne(range: IntRange): Int {
    return range.map(Int::toString).filter(String::isAValidPassword).count()
}

fun String.isAValidPassword() =
    neverDecrease() && hasTwoAdjacentDigits()

private fun String.hasTwoAdjacentDigits() =
    this.split("")
        .filter(String::isNotBlank)
        .groupBy { it }
        .values
        .count { it.size >= 2 } >= 1

private fun String.neverDecrease() =
    this == this.split("").sorted().joinToString(separator = "")

