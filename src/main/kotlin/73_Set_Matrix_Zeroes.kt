fun main() {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        var frz = false
        var fcz = false

        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] == 0) {
                    if (i == 0) frz = true
                    if (j == 0) fcz = true
                    matrix[i][0] = 0
                    matrix[0][j] = 0
                }
            }
        }

        for (i in 1 until matrix.size) {
            for (j in 1 until matrix[0].size) {
                if (matrix[i][0] == 0) matrix[i][j] = 0
                if (matrix[0][j] == 0) matrix[i][j] = 0
            }
        }

        if (frz) for (i in matrix[0].indices) matrix[0][i] = 0
        if (fcz) for (i in matrix.indices) matrix[i][0] = 0
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

    setZeroes(matrix.toTypedArray())

    println(matrix.joinToString("\n") { it.toList().toString() })
}
