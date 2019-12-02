package dev.tangzero.aoc2019.day02

fun partTwo() {
    val codes = intCodes()
    val result = processV2(codes)
    println("Part Two: the 100 * noun + verb is $result")
}

fun processV2(originalCodes: IntCodes): Int {
    for (noun in 0..99) {
        for (verb in 0..99) {
            val codes = originalCodes.toMutableList()
            codes[1] = noun
            codes[2] = verb
            process(codes)
            if (codes[0] == 19690720) {
                return 100 * noun + verb
            }
        }
    }
    return 0
}

