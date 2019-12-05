package dev.tangzero.aoc2019.day05

object PartTwo {

    private enum class ParamMode { POSITION, IMMEDIATE }

    private data class Operation(
        val code: Int,
        val mode1: ParamMode,
        val mode2: ParamMode,
        val mode3: ParamMode
    )

    fun process(memory: IntCodes, input: Int) {
        var pc = 0
        while (true) {
            val op = parseOperation(memory[pc])
            pc = when (op.code) {
                1 -> operate(pc, op, memory, Int::plus)
                2 -> operate(pc, op, memory, Int::times)
                3 -> read(pc, memory, input)
                4 -> write(pc, op, memory)
                5 -> jumpIfTrue(pc, op, memory)
                6 -> jumpIfFalse(pc, op, memory)
                7 -> isLessThan(pc, op, memory)
                8 -> isEquals(pc, op, memory)
                99 -> return
                else -> throw IllegalStateException("invalid code: ${op.code}")
            }
        }
    }

    private fun parseOperation(code: Int): Operation {
        val params = String.format("%04d", code)
        return Operation(
            params.substring(2).toInt(),
            ParamMode.values()[params.substring(1..1).toInt()],
            ParamMode.values()[params.substring(0..0).toInt()],
            ParamMode.POSITION)
    }

    private fun value(value: Int, memory: IntCodes, mode: ParamMode) =
        when (mode) {
            ParamMode.POSITION -> memory[value]
            ParamMode.IMMEDIATE -> value
        }

    private fun operate(pc: Int, op: Operation, memory: IntCodes, action: (Int, Int) -> Int): Int {
        val (p1, p2, p3) = memory.slice(pc + 1..pc + 3)
        memory[p3] = action(value(p1, memory, op.mode1), value(p2, memory, op.mode2))
        return pc + 4 // instruction size
    }

    private fun read(pc: Int, memory: IntCodes, input: Int): Int {
        memory[memory[pc + 1]] = input
        return pc + 2 // instruction size
    }

    private fun write(pc: Int, op: Operation, memory: IntCodes): Int {
        val value = value(memory[pc + 1], memory, op.mode1)
        println(value)
        return pc + 2 // instruction size
    }

    private fun jumpIfTrue(pc: Int, op: Operation, memory: IntCodes) =
        jump(pc, op, memory) { it != 0 }

    private fun jumpIfFalse(pc: Int, op: Operation, memory: IntCodes) =
        jump(pc, op, memory) { it == 0 }

    private fun jump(pc: Int, op: Operation, memory: IntCodes, condition: (Int) -> Boolean): Int {
        val param1 = value(memory[pc + 1], memory, op.mode1)
        val param2 = value(memory[pc + 2], memory, op.mode2)
        if (condition(param1)) {
            return param2
        }
        return pc + 3 // instruction size
    }

    private fun isLessThan(pc: Int, op: Operation, memory: IntCodes) =
        store(pc, op, memory) { p1, p2 -> p1 < p2 }

    private fun isEquals(pc: Int, op: Operation, memory: IntCodes) =
        store(pc, op, memory) { p1, p2 -> p1 == p2 }

    private fun store(pc: Int, op: Operation, memory: IntCodes, condition: (Int, Int) -> Boolean): Int {
        val (p1, p2, p3) = memory.slice(pc + 1..pc + 3)
        val param1 = value(p1, memory, op.mode1)
        val param2 = value(p2, memory, op.mode2)
        memory[p3] = if (condition(param1, param2)) 1 else 0
        return pc + 4 // instruction size
    }
}
