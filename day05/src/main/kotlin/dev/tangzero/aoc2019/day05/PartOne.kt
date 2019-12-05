package dev.tangzero.aoc2019.day05

fun partOne(codes: IntCodes) = process(codes)

enum class ParamMode { POSITION, IMMEDIATE }

data class Operation(
    val code: Int,
    val mode1: ParamMode,
    val mode2: ParamMode,
    val mode3: ParamMode
)

fun process(memory: IntCodes) {
    var pc = 0
    while (true) {
        val op = parseOperation(memory[pc])
        pc += when (op.code) {
            1 -> operate(pc, op, memory, Int::plus)
            2 -> operate(pc, op, memory, Int::times)
            3 -> read(pc, op, memory)
            4 -> write(pc, op, memory)
            99 -> return
            else -> throw IllegalStateException("invalid code: ${op.code}")
        }
    }
}

fun parseOperation(code: Int): Operation {
    val params = String.format("%04d", code)
    return Operation(
        params.substring(2).toInt(),
        ParamMode.values()[params.substring(1..1).toInt()],
        ParamMode.values()[params.substring(0..0).toInt()],
        ParamMode.POSITION)
}

fun value(value: Int, memory: IntCodes, mode: ParamMode) =
    when (mode) {
        ParamMode.POSITION -> memory[value]
        ParamMode.IMMEDIATE -> value
    }

fun operate(pc: Int, op: Operation, memory: IntCodes, action: (Int, Int) -> Int): Int {
    val (p1, p2, p3) = memory.slice(pc + 1..pc + 3)
    memory[p3] = action(value(p1, memory, op.mode1), value(p2, memory, op.mode2))
    return 4 // instruction size
}

@SuppressWarnings("unused")
fun read(pc: Int, op: Operation, memory: IntCodes): Int {
    memory[memory[pc + 1]] = 1 // readLine()!!.toInt()
    return 2 // instruction size
}

fun write(pc: Int, op: Operation, memory: IntCodes): Int {
    val value = value(memory[pc + 1], memory, op.mode1)
    if (value != 0 && memory[pc + 2] != 99) {
        throw IllegalStateException("error output: $value")
    }
    println(value)
    return 2 // instruction size
}
