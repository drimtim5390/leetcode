import kotlin.math.sqrt

fun main() {
    fun integerBreak(n: Int): Int {
        if (n < 4) return n - 1
        var s = n
        var result = 1
        while (s > 4) {
            result *= 3
            s -= 3
        }
        return result * s
    }

    val s = readln().toInt()
    println(integerBreak(s))
}
