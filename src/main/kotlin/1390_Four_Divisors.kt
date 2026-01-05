import kotlin.math.sqrt

fun main() {
    fun sumFourDivisors(nums: IntArray): Int {
        var result = 0
        val m = mutableMapOf<Int, Int>()
        for (num in nums) {
            if (m.containsKey(num)) {
                result += m[num]!!
                continue
            }

            var div = 0
            val n = sqrt(num.toDouble()).toInt()

            for (i in 2..n) {
                if (num % i == 0) {
                    if (num / i == i || div != 0) {
                        div = 0
                        break
                    }
                    div = i
                }
            }

            m[num] = 0
            if (div != 0) {
                m[num] = 1 + num + div + num / div
            }

            result += m[num]!!
        }

        return result
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(sumFourDivisors(s))
}