fun main() {
    fun numSpecial(mat: Array<IntArray>): Int {
        var special = 0

        for (i in mat.indices) {
            for (j in 0 until mat[0].size) {
                if (mat[i][j] != 1) {
                    continue
                }
                var isSpecial = true
                for (k in mat.indices) {
                    if (k == i) continue
                    if (mat[k][j] != 0) {
                        isSpecial = false
                        break;
                    }
                }
                if (!isSpecial) continue
                for (k in 0 until mat[0].size) {
                    if (k == j) continue
                    if (mat[i][k] != 0) {
                        isSpecial = false
                        break;
                    }
                }
                if (!isSpecial) continue
                special++
            }
        }

        return special
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
    println(numSpecial(matrix.toTypedArray()))
}
