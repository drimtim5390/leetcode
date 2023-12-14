fun main() {
    fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
        val rows = grid.size
        val cols = grid[0].size
        val onesRow = IntArray(rows)
        val onesCol = IntArray(cols)
        val zeroesRow = IntArray(rows)
        val zeroesCol = IntArray(cols)

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (grid[i][j] == 0) {
                    zeroesRow[i]++
                    zeroesCol[j]++
                } else {
                    onesRow[i]++
                    onesCol[j]++
                }
            }
        }

        val result = Array(rows) { IntArray(cols) { 0 } }
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                result[i][j] = onesRow[i] + onesCol[j] - zeroesRow[i] - zeroesCol[j]
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
    println(onesMinusZeros(matrix.toTypedArray()))
}
