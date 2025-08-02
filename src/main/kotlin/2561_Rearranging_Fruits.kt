import kotlin.math.absoluteValue

fun main() {
    fun minCost(basket1: IntArray, basket2: IntArray): Long {
        val map = hashMapOf<Int, Int>()
        var min = basket1[0]

        for (i in basket1) {
            map[i] = map.getOrDefault(i, 0) + 1
        }

        for (i in basket2) {
            map[i] = map.getOrDefault(i, 0) - 1
        }

        val list = mutableListOf<Long>()
        for ((k, v) in map) {
            if (v % 2 != 0) return -1L
            repeat((v / 2).absoluteValue) {
                list.add(k.toLong())
            }
            min = minOf(min, k)
        }

        return list.sorted().take(list.size / 2).sumOf {
            if (it > 2 * min.toLong()) {
                2 * min.toLong()
            } else {
                it
            }
        }
    }

    fun readArray(s: String): IntArray {
        return s
            .replace("[", "")
            .replace("]", "")
            .replace(",", " ")
            .split(" ")
            .map { it.toInt() }
            .toIntArray()
    }

    val basket1 = readArray(readln())
    val basket2 = readArray(readln())

    println(minCost(basket1, basket2))
}
