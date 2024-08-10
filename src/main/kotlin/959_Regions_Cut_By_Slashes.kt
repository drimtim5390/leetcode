fun main() {
    fun regionsBySlashes(grid: Array<String>): Int {
        println(grid.joinToString("\n") { "\"$it\"" })
        val n = grid.size
        var count = 0
        val matrix = Array(n * 3) { BooleanArray(n * 3) }
        for (i in 0 until n) {
            for (j in 0 until n) {
                val r = i * 3
                val c = j * 3
                when (grid[i][j]) {
                    '/' -> {
                        matrix[r][c + 2] = true
                        matrix[r + 1][c + 1] = true
                        matrix[r + 2][c] = true
                    }
                    '\\' -> {
                        matrix[r][c] = true
                        matrix[r + 1][c + 1] = true
                        matrix[r + 2][c + 2] = true
                    }
                }
            }
        }

        fun fill(i: Int, j: Int) {
            if (i >= n * 3 || j >= n * 3 || i < 0 || j < 0) return
            if (matrix[i][j]) return
            matrix[i][j] = true
            fill(i, j + 1)
            fill(i, j - 1)
            fill(i + 1, j)
            fill(i - 1, j)
        }

        for (i in 0 until n * 3) {
            for (j in 0 until n * 3) {
                if (!matrix[i][j]) {
                    count++
                    fill(i, j)
                }
            }
        }
        return count
    }

    val s = readln().replace("[", "").replace("]", "").replace("\"", "").replace("\\\\", "\\").split(",").toTypedArray()
    println(regionsBySlashes(s))
}
