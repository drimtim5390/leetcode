import kotlin.math.sqrt

fun main() {
    fun minSteps(n: Int): Int {
        var result = 0
        var s = n
        for (i in 2..sqrt(n.toDouble()).toInt() + 1) {
            while (s % i == 0) {
                result += i
                s /= i
            }
        }
        if (s > 1) result += s
        return result
    }

    val n = readln().toInt()
    println(minSteps(n))
}
