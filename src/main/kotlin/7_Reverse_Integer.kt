import kotlin.math.abs
import kotlin.math.sign

fun main() {
    fun reverse(x: Int): Int {
        val sign = x.sign
        var num = abs(x.toLong())
        var result = 0L

        while (num > 0) {
            result = result * 10 + (num % 10)
            num = num / 10
        }

        if (result > Int.MAX_VALUE) {
            return 0
        }

        return result.toInt() * sign
    }

    val s = readln().toInt()
    println(reverse(s))
}
