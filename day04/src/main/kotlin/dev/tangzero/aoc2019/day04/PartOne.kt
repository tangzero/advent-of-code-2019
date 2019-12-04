package dev.tangzero.aoc2019.day04

fun partOne(range: IntRange): Int {
    return range.map(Int::toString).filter(String::isAValidPassword).count()
}

fun String.isAValidPassword() =
    hasTwoAdjacentDigits() && neverDecrease()

fun String.hasTwoAdjacentDigits(): Boolean {
    for (i in 1 until length) {
        if (this[i] == this[i - 1]) {
            return true
        }
    }
    return false
}

fun String.neverDecrease() =
    this == this.split("").sorted().joinToString(separator = "")

