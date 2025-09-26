import kotlin.math.abs

fun main() {
    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        if (numerator == 0) return "0"
        val result = StringBuilder()
        if ((numerator >= 0) xor (denominator > 0)) result.append("-")
        val num = abs(numerator.toLong())
        val den = abs(denominator.toLong())

        result.append(num / den)
        var rem = num % den
        if (rem == 0L) return result.toString()

        result.append(".")

        val seen = mutableMapOf<Long, Int>()
        var i = result.length
        while (rem != 0L) {
            val pos = seen[rem]
            if (pos != null) {
                result.insert(pos, "(")
                result.append(")")
                break
            }
            seen[rem] = i++
            rem *= 10L
            result.append(rem / den)
            rem %= den
        }

        return result.toString()
    }

    val nom = readln().toInt()
    val den = readln().toInt()
    println(fractionToDecimal(nom, den))
}
