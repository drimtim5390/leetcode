import kotlin.math.abs

fun main() {
    fun check24(cards: MutableList<Double>): Boolean {
        val n = cards.size
        if (n == 1) return abs(cards[0] - 24) < 0.000001
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                val c1 = cards[i]
                val c2 = cards[j]
                val next = mutableListOf<Double>()
                next.add(c1 + c2)
                next.add(c1 - c2)
                next.add(c2 - c1)
                next.add(c1 * c2)
                if (c1 != 0.0) next.add(c2 / c1)
                if (c2 != 0.0) next.add(c1 / c2)

                for (num in next) {
                    val doubles = mutableListOf<Double>()
                    doubles.add(num)
                    for (k in 0 until n) {
                        if (k != i && k != j) doubles.add(cards[k])
                    }
                    if (check24(doubles)) return true
                }
            }
        }
        return false
    }

    fun judgePoint24(cards: IntArray): Boolean {
        val doubles = cards.map { it.toDouble() }.toMutableList()
        return check24(doubles)
    }

    val s = readln().replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(judgePoint24(s))
}
