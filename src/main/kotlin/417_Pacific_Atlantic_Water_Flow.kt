fun main() {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val directions = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, -1),
            intArrayOf(0, 1),
        )

        val result = mutableListOf<List<Int>>()
        val n = heights.size
        val m = heights[0].size
        val pacific = Array(n) { BooleanArray(m) }
        val atlantic = Array(n) { BooleanArray(m) }

        fun dfs(x: Int, y: Int, set: Array<BooleanArray>) {
            if (set[x][y]) return
            set[x][y] = true
            val h = heights[x][y]
            for (direction in directions) {
                val r = x + direction[0]
                val c = y + direction[1]

                if (r in 0 until n && c in 0 until m && h <= heights[r][c]) {
                    dfs(r, c, set)
                }
            }
        }

        for (i in 0 until n) {
            dfs(i, 0, pacific)
            dfs(i, m - 1, atlantic)
        }

        for (i in 0 until m) {
            dfs(0, i, pacific)
            dfs(n - 1, i, atlantic)
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(listOf(i, j))
                }
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
            .split(" ")
            .map { it.toInt() }.toIntArray()
        matrix.add(array)
    }
    println(pacificAtlantic(matrix.toTypedArray()))
}
