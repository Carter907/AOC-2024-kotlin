fun main() {
    fun part1(input: List<String>): Int {

        val regex = Regex("mul\\(\\d{1,3},\\d{1,3}\\)")
        val dodontregex = Regex("(don\'t\\(\\))|(do\\(\\))")
        var sum = 0
        var i: Int
        var dod = true
        var match: MatchResult?
        for (line in input) {
            i = 0
            match = regex.find(line, i)
            while (i < line.length && match != null) {

                match.let {
                    dodontregex.findAll(line.substring(i, it.range.first)).let {

                        if (it.count() > 0 && it.last().value == "do()") {
                            dod = true
                        } else if (it.count() > 0 && it.last().value == "don't()") {
                            dod = false
                        }
                    }
                    if (dod) {
                        // add mul
                        val first = it.value.substringAfter("(").substringBefore(",").toInt()
                        val second = it.value.substringAfter(",").substringBefore(")").toInt()
                        sum += first * second

                    }

                    i = it.range.first + 1
                }


                match = regex.find(line, i)
            }

        }


        return sum
    }

    fun part2(input: List<String>): Any {
        return 0
    }


    // Read the input from the `src/Day01.txt` file.
    val input = readInput("day3-input")
    part1(input).println()
    part2(input).println()

}