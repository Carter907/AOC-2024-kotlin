fun main() {
    fun part1(input: List<String>): Int {

        val (first, last) = input.map {
                it.substringBefore(" ").toInt() to it.substringAfterLast(" ").toInt()
        }.unzip()

        val totalDistance = first.sorted()
            .zip(last.sorted())
            .sumOf{ p -> kotlin.math.abs(p.first - p.second) }

        return totalDistance
    }

    fun part2(input: List<String>): Int {
        val (first, last) = input.map { it.split(" ").first()
            .toInt() to it.split(" ").last()
            .toInt()
        }.unzip()

        return first.distinct().associateBy(
            keySelector = { it },
            valueTransform = { lhs -> last.count { rhs -> rhs == lhs } }
        ).map { (first, last) -> first*last }.sum()
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("day1-input")
    part1(input).println()
    part2(input).println()
}
