fun main() {
    fun part1(input: List<String>): Int {

        val (sec1, sec2) = input.partition { it.contains("|") }
        val rules = sec1.map {
            val split = it.split("|").map { it.toInt() }; Pair(
            split[0],
            split[1]
        )
        }
        val updates = sec2.map {
            it.trim().split(",").filter {
                it.isNotBlank() && it.isNotEmpty()
            }.map { it.toInt() }
        }.filter { it.isNotEmpty() }
        // brute force
        var sum = 0
        for (update in updates) {
            println(update)
            var valid = true
            for (rule in rules) {
                if (update.contains(rule.first) && update.contains(rule.second) &&
                    update.indexOf(rule.first) > update.indexOf(rule.second)
                ) {
                    valid = false
                }
            }
            if (valid) {
                sum += update[update.size / 2].toInt()
            }
        }

        return sum
    }

    fun part2(input: List<String>): Int {

        val (sec1, sec2) = input.partition { it.contains("|") }
        val rules = sec1.map {
            val split = it.split("|").map { it.toInt() }; Pair(
            split[0],
            split[1]
        )
        }
        val updates = sec2.map {
            it.trim().split(",").filter {
                it.isNotBlank() && it.isNotEmpty()
            }.map { it.toInt() }
        }.filter { it.isNotEmpty() }
        // brute force
        var sum = 0
        for (i in 0 until updates.size) {
            var update = updates[i].toMutableList()
            var valid = true

            for (rule in rules) {
                if (update.contains(rule.first) && update.contains(rule.second) &&
                    update.indexOf(rule.first) > update.indexOf(rule.second)
                ) {
                    valid = false

                    break;
                }
            }
            if (!valid) {
                sum += update[update.size / 2].toInt()
            }
        }

        return sum
    }


    // Read the input from the `src/Day01.txt` file.
    val input = readInput("day5-input")
    part1(input).println()
    part2(input).println()

}