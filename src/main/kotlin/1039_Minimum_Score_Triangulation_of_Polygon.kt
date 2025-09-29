fun main() {
    fun minScoreTriangulation(values: IntArray): Int {
        val n = values.size
        val memo = Array(n + 1) { IntArray(n + 1) { -1 } }

        fun dp(i: Int, j: Int): Int {
            if (i + 1 == j) return 0
            if (memo[i][j] != -1) return memo[i][j]
            var minScore = Int.MAX_VALUE
            for (k in i + 1 until j) {
                val res = values[i] * values[k] * values[j] + dp(i, k) + dp(k, j)
                minScore = Math.min(minScore, res)
            }
            memo[i][j] = minScore
            return memo[i][j]
        }

        return dp(0, n - 1)
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(minScoreTriangulation(s))
}
