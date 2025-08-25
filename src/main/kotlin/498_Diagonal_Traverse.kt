fun main() {
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        val n = mat.size
        val m = mat[0].size
        val result = IntArray(n * m)
        var up = true
        var i = 0
        var j = 0
        var index = 0
        while (index < n * m) {
            result[index++] = mat[i][j]

            if (up) {
                i--
                j++
            } else {
                i++
                j--
            }

            if (up) {
                if (j >= m) {
                    i += 2
                    j--
                    up = false
                }
                if (i < 0) {
                    i++
                    up = false
                }
            } else {
                if (i >= n) {
                    i--
                    j += 2
                    up = true
                }
                if (j < 0) {
                    j++
                    up = true
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
            .split(" ").map { it.toInt() }.toIntArray()
        matrix.add(array)
    }
    println(findDiagonalOrder(matrix.toTypedArray()).toList())
}
