package dev.tangzero.aoc2019.day02

fun partOne() {
    val codes = intCodes()
    codes[1] = 12
    codes[2] = 2
    process(codes)
    println("Part One: the value left at position 0 is ${codes[0]}")
}

fun process(codes: IntCodes) {
    var pc = 0
    while (true) {
        when (codes[pc]) {
            1 -> operate(pc, codes, Int::plus)
            2 -> operate(pc, codes, Int::times)
            99 -> return
        }
        pc += 4
    }
}

fun operate(pc: Int, codes: IntCodes, operation: (Int, Int) -> Int) {
    codes[codes[pc + 3]] = operation(codes[codes[pc + 1]], codes[codes[pc + 2]])
}

