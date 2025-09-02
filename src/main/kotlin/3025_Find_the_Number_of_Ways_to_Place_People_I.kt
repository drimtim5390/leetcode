fun main() {
    fun numberOfPairs(points: Array<IntArray>): Int {
        val n = points.size
        var result = 0


        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == j) continue

                val a = points[i]
                val b = points[j]


                if (a[0] <= b[0] && a[1] >= b[1]) {
                    var valid = true
                    for (k in 0 until n) {
                        if (k == i || k == j) continue
                        val x = points[k]
                        if (x[0] >= a[0] && x[0] <= b[0] && x[1] <= a[1] && x[1] >= b[1]) {
                            valid = false
                            break
                        }
                    }
                    if (valid) {
                        result++
                    }
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
    println(numberOfPairs(matrix.toTypedArray()))
}
