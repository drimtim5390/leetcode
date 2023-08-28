package solving

import kotlin.math.abs
import kotlin.math.min

fun main() {
    val m = readln().toInt()
    val n = readln().toInt()
    val mat = Array(n) { IntArray(m) }
    for (i in 0 until m) {
        mat[i] = readln().split(" ").map { it.toInt() }.toIntArray()
    }
    println(updateMatrix(mat).contentDeepToString())
}

fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
    val zeros = mutableSetOf<Pair<Int, Int>>()
    var i = 0
    var j: Int
    val result = Array(mat.size) { IntArray(mat[0].size )}
    for (s in mat) {
        j = 0
        for (num in s) {
            if (num == 0) {
                zeros.add(Pair(i, j))
            }
            j++
        }
        i++
    }
    i = 0
    for (s in mat) {
        j = 0
        for (num in s) {
            if (num != 0) {
                result[i][j] = with(zeros) {
                    var tmpMin = Int.MAX_VALUE
                    this.forEach {
                        tmpMin = min(abs(i - it.first) + abs(j - it.second), tmpMin)
                    }
                    tmpMin
                }
            }
            j++
        }
        i++
    }
    return result
}

