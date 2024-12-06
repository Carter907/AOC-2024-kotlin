fun main() {
    fun part1(input: List<String>): Int {
        val mat = input.map { it.toCharArray() }
        var count = 0

        for (i in mat.indices) {
            for (j in mat[i].indices) {
                if (mat[i][j] == 'A') {

                    // NorthEast
                    if (j < mat[i].size - 3 && i > 2) {
                        if (mat[i - 1][j + 1] == 'M' && mat[i - 2][j + 2] == 'A' && mat[i - 3][j + 3] == 'S') {
                            count++
                        }
                    }
                    // NorthWest
                    if (j > 2 && i > 2) {
                        if (mat[i - 1][j - 1] == 'M' && mat[i - 2][j - 2] == 'A' && mat[i - 3][j - 3] == 'S') {
                            count++
                        }
                    }
                    // SouthEast
                    if (j < mat[i].size - 3 && i < mat.size - 3) {
                        if (mat[i + 1][j + 1] == 'M' && mat[i + 2][j + 2] == 'A' && mat[i + 3][j + 3] == 'S') {
                            count++
                        }
                    }
                    // SouthWest
                    if (j > 2 && i < mat.size - 3) {
                        if (mat[i + 1][j - 1] == 'M' && mat[i + 2][j - 2] == 'A' && mat[i + 3][j - 3] == 'S') {
                            count++
                        }
                    }


                }
            }
        }


        return count
    }

    fun part2(input: List<String>): Int {
        val mat = input.map { it.toCharArray() }
        var count = 0

        for (i in mat.indices) {
            for (j in mat[i].indices) {
                if (mat[i][j] == 'A') {
                    if (i < mat.size - 1 && i > 0 && j > 0 && j < mat[i].size - 1) {
                        // both forwards
                        if (mat[i - 1][j - 1] == 'M' && mat[i + 1][j + 1] == 'S' && mat[i + 1][j - 1] == 'M' && mat[i - 1][j + 1] == 'S') {
                            count++
                        }
                        // both backwards
                        else if (mat[i - 1][j - 1] == 'S' && mat[i + 1][j + 1] == 'M' && mat[i + 1][j - 1] == 'S' && mat[i - 1][j + 1] == 'M') {
                            count++
                        }
                        // first forward second backward
                        else if (mat[i - 1][j - 1] == 'M' && mat[i + 1][j + 1] == 'S' && mat[i + 1][j - 1] == 'S' && mat[i - 1][j + 1] == 'M') {
                            count++
                        }
                        // first backward second forward
                        else if (mat[i - 1][j - 1] == 'S' && mat[i + 1][j + 1] == 'M' && mat[i + 1][j - 1] == 'M' && mat[i - 1][j + 1] == 'S') {
                            count++
                        }
                    }
                }
            }
        }


        return count

    }


    // Read the input from the `src/Day01.txt` file.
    val input = readInput("day4-input")
    part1(input).println()
    part2(input).println()

}