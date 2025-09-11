import java.util.PriorityQueue

fun main() {
    fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
        fun gain(pass: Int, total: Int): Double {
            return (pass + 1).toDouble() / (total + 1) - pass.toDouble() / total
        }

        var sum = 0.0
        val pq = PriorityQueue<IntArray> { a, b -> gain(b[0], b[1]).compareTo(gain(a[0], a[1])) }

        for (c in classes) {
            sum += c[0].toDouble() / c[1]
            pq.add(c)
        }

        var extra = extraStudents
        while (extra > 0) {
            val top = pq.poll()
            sum -= top[0].toDouble() / top[1]
            top[0]++
            top[1]++
            sum += top[0].toDouble() / top[1]
            pq.add(top)
        }

        return sum
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

    val extra = readln().toInt()

    println(maxAverageRatio(matrix.toTypedArray(), extra))
}
