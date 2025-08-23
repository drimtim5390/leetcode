fun main() {
    fun minimumSum2(grid: Array<IntArray>, u: Int, d: Int, l: Int, r: Int): Int {
        var minI = grid.size
        var maxI = -1
        var minJ = grid[0].size
        var maxJ = -1

        for (i in u..d) {
            for (j in l..r) {
                if (grid[i][j] == 1) {
                    if (i < minI) minI = i
                    if (i > maxI) maxI = i
                    if (j < minJ) minJ = j
                    if (j > maxJ) maxJ = j
                }
            }
        }

        return if (minI <= maxI) {
            (maxI - minI + 1) * (maxJ - minJ + 1)
        } else {
            Int.MAX_VALUE / 3
        }
    }

    fun rotate(vec: Array<IntArray>): Array<IntArray> {
        val n = vec.size
        val m = vec[0].size
        val ret = Array(m) { IntArray(n) }
        for (i in 0 until n) {
            for (j in 0 until m) {
                ret[m - j - 1][i] = vec[i][j]
            }
        }
        return ret
    }

    fun solve(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size
        var res = n * m

        // Partition into 3 rectangles (L or inverted L shapes)
        for (i in 0 until n - 1) {
            for (j in 0 until m - 1) {
                res = minOf(
                    res,
                    minimumSum2(grid, 0, i, 0, m - 1) +
                            minimumSum2(grid, i + 1, n - 1, 0, j) +
                            minimumSum2(grid, i + 1, n - 1, j + 1, m - 1)
                )
                res = minOf(
                    res,
                    minimumSum2(grid, 0, i, 0, j) +
                            minimumSum2(grid, 0, i, j + 1, m - 1) +
                            minimumSum2(grid, i + 1, n - 1, 0, m - 1)
                )
            }
        }

        for (i in 0 until n - 2) {
            for (j in i + 1 until n - 1) {
                res = minOf(
                    res,
                    minimumSum2(grid, 0, i, 0, m - 1) +
                            minimumSum2(grid, i + 1, j, 0, m - 1) +
                            minimumSum2(grid, j + 1, n - 1, 0, m - 1)
                )
            }
        }

        return res
    }

    fun minimumSum(grid: Array<IntArray>): Int {
        val rgrid = rotate(grid)
        return minOf(solve(grid), solve(rgrid))
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
    println(minimumSum(matrix.toTypedArray()))
}
