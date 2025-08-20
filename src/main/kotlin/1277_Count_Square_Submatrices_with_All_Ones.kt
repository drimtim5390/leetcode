fun main() {
    fun countSquares(matrix: Array<IntArray>): Int {
        val n = matrix.size
        val m = matrix[0].size
        var result = 0

        val dp = Array(n) { i -> IntArray(m) { j -> matrix[i][j] } }

        for (i in 0 until n) {
            if (dp[i][0] == 1) result++
        }

        for (j in 1 until m) {
            if (dp[0][j] == 1) result++
        }

        for (i in 1 until n) {
            for (j in 1 until m) {
                if (dp[i][j] > 0) {
                    dp[i][j] = minOf(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1
                    result += dp[i][j]
                }
            }
        }

        return result
    }

    val matrix = mutableListOf<IntArray>()

    val s = readln()

    for (x in s.split("],[")) {
        val array = x
            .replace("[", "")
            .replace("]", "")
            .replace(",", " ")
            .split(" ").map { it.toInt() }.toIntArray()
        matrix.add(array)
    }
    println(countSquares(matrix.toTypedArray()))
}
