fun main() {
    fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
        val matrix = Array(rowSum.size) { IntArray(colSum.size) }
        for (i in rowSum.indices) {
            matrix[i][0] = rowSum[i]
        }
        for (j in colSum.indices) {
            var sum = colSum[j]
            for (i in rowSum.indices) {
                if (sum >= matrix[i][j]) {
                    sum -= matrix[i][j]
                } else {
                    matrix[i][j + 1] = matrix[i][j] - sum
                    matrix[i][j] = sum
                    sum = 0
                }
            }
        }
        return matrix
    }

    val rowSum = readln().replace("[", "").replace("]", "").split(",").map { it.toInt() }.toIntArray()
    val colSum = readln().replace("[", "").replace("]", "").split(",").map { it.toInt() }.toIntArray()
    println(restoreMatrix(rowSum, colSum).joinToString("\n") { it.joinToString(" ") })
}
