import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.log2

fun main() {
    fun productQueries(n: Int, queries: Array<IntArray>): IntArray {
        val result = IntArray(queries.size)
        val powers = mutableListOf<Int>()
        var x = n.toDouble()
        while (x > 0) {
            val tmp = log2(x)
            val power = 2.toDouble().pow(floor(tmp))
            x -= power
            powers.add(power.toInt())
        }

        powers.sort()

        for((index, query) in queries.withIndex()) {
            var res = 1L
            for (i in query[0]..query[1]) {
                res*=powers[i]
                res%=1000000007
            }
            result[index] = res.toInt()
        }

        return result
    }

    val n = readln().toInt()
    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()

    val queries = Array(n / 2) { IntArray(2) }

    for ((index, value) in s.withIndex()) {
        queries[index / 2][index % 2] = value
    }

    println(productQueries(n, queries))
}
