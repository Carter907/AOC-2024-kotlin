fun isSafe(input: List<Int>): Boolean {
    var res = true

    input.windowed(2) {
        val dist = kotlin.math.abs(it[0] - it[1])
        if (dist > 3 || dist == 0) {
            res = false
        }
    }

    if (input != input.sorted() && input != input.sorted().reversed()) {
        res = false
    }

    return res
}

fun isDampenSafe(input: List<Int>): Boolean {

    for (i in input.indices) {
        if (isSafe(input.slice((0..<i)+(i+1..<input.size)))) {
            return true
        }
    }

    return false
}

fun main() {
    fun part1(input: List<String>): Int {

        return input.count { report -> isSafe(report.split(" ").map { level -> level.toInt() }) }
    }
    fun part2(input: List<String>): Any {
        return input.count { report -> isDampenSafe(report.split(" ").map { level -> level.toInt() }) }
    }


    // Read the input from the `src/Day01.txt` file.
    val input = readInput("day2-input")
    part1(input).println()
    part2(input).println()

}


