fun main() {
    val s = readln().toInt()
    println(addDigits(s))
}

private fun addDigits(num: Int): Int {
    var result = num
    var sum: Int

    while (result / 10 > 0) {
        sum = 0
        while (result / 10 > 0) {
            sum += result % 10
            result /= 10
        }
        result = sum + result % 10
    }

    return result
}

