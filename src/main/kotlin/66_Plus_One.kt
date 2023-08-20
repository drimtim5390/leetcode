fun main() {
    val s = readln().split(" ").map { it.toInt() }.toIntArray()
    println(plusOne(s).joinToString())
}

fun plusOne(digits: IntArray): IntArray {
    for (i in (digits.size - 1) downTo 0) {
        if (digits[i] < 9) {
            digits[i]++
            return digits
        }
        digits[i] = 0;
    }
    val result = IntArray(digits.size + 1)
    result[0] = 1
    return result
}