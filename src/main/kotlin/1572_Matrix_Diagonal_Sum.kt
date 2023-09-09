fun main() {
    val matrix = mutableListOf<IntArray>()
    var s = readln()
    while (s != "") {
        matrix.add(s.split(" ").map { it.toInt() }.toIntArray())
        s = readln()
    }
    println(diagonalSum(matrix.toTypedArray()))
}

private fun diagonalSum(mat: Array<IntArray>): Int {
    var result = 0
    val n = mat.size - 1
    for (i in mat.indices) {
        result += mat[i][i]
        result += mat[i][n - i]
    }

    if (mat.size % 2 != 0) {
        val index = mat.size / 2
        result -= mat[index][index]
    }

    return result
}

