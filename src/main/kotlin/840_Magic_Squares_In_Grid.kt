fun main() {
    fun numMagicSquaresInside(grid: Array<IntArray>): Int {
        var result = 0
        val rows = grid.size
        val cols = grid.first().size
        val magicSet = setOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        if (rows < 3 || cols < 3) return result
        for (i in 0..rows - 3) {
            for (j in 0..cols - 3) {
                val numSet = setOf(
                    grid[i][j], grid[i][j + 1], grid[i][j + 2],
                    grid[i + 1][j], grid[i + 1][j + 1], grid[i + 1][j + 2],
                    grid[i + 2][j], grid[i + 2][j + 1], grid[i + 2][j + 2],
                )
                if (numSet != magicSet) continue
                val sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2]
                if (grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] == sum &&
                    grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] == sum &&
                    grid[i][j] + grid[i + 1][j] + grid[i + 2][j] == sum &&
                    grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] == sum &&
                    grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] == sum &&
                    grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] == sum &&
                    grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] == sum
                )
                    result++
            }
        }
        return result
    }

    val s = readln()
    val matrix = mutableListOf<IntArray>()
    for (x in s.split("],[")) {
        val array = x
            .replace("[", "")
            .replace("]", "")
            .replace(",", " ")
            .split(" ").map { it.toInt() }.toIntArray()
        matrix.add(array)
    }
    println(numMagicSquaresInside(matrix.toTypedArray()))
}