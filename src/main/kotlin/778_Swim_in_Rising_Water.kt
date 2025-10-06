fun main() {
    fun swimInWater(grid: Array<IntArray>): Int {
        val dirs = intArrayOf(0, 1, 0, -1, 0)
        val n = grid.size

        var t = grid[n - 1][n - 1]
        var visited = Array(n) { BooleanArray(n) }
        var reachedLastLocation = false

        fun visit(x: Int, y: Int) {
            val s = grid[x][y]
            if (x == n - 1 && y == n - 1) {
                reachedLastLocation = true
                if (t < s) t = s
                return
            }

            visited[x][y] = true

            if (s <= t) {
                for (i in 0..3) {
                    val r = x + dirs[i]
                    val c = y + dirs[i + 1]
                    if (r in 0 until n && c in 0 until n && !visited[r][c]) {
                        visit(r, c)
                    }
                }
            }
        }

        while (true) {
            visit(0, 0)
            if (reachedLastLocation) break
            else t++
            visited = Array(n) { BooleanArray(n) }
        }
        return t
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
    println(swimInWater(matrix.toTypedArray()))
}
