import kotlin.math.pow

fun main() {
    fun maximum69Number(num: Int): Int {
        var temp = num
        var pos = -1
        var index = 0
        while (temp > 0) {
            if (temp % 10 == 6) pos = index
            temp /= 10
            index++
        }
        return if (pos == -1) num else num + 3 * 10.0.pow(pos.toDouble()).toInt()
    }

    val s = readln().toInt()
    println(maximum69Number(s))
}
