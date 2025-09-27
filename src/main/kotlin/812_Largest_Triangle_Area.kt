fun main() {
    fun largestTriangleArea(points: Array<IntArray>): Double {
        fun calcArea(a: IntArray, b: IntArray, c: IntArray): Double {
            return Math.abs(a[0] * (b[1] - c[1]) + b[0] * (c[1] - a[1]) + c[0] * (a[1] - b[1])) / 2.0
        }

        val n = points.size
        var max = 0.0

        for (i in 0 until n) {
            for (j in i + 1 until n) {
                for (k in j + 1 until n) {
                    val s = calcArea(points[i], points[j], points[k])
                    max = Math.max(max, s)
                }
            }
        }

        return max
    }

    val s = readln()
    val matrix = mutableListOf<IntArray>()
    for (x in s.split("],[")) {
        val array = x.replace("[", "").replace("]", "").replace(",", " ").split(" ").map { it.toInt() }.toIntArray()
        matrix.add(array)
    }
    println(largestTriangleArea(matrix.toTypedArray()))
}
