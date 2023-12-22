fun main() {
    fun maxScore(s: String): Int {
        var result = 0
        var zeros = 0
        var ones = s.count { it == '1' }

        for (i in 0 until s.lastIndex) {
            if (s[i] == '0') zeros++ else ones--
            result = maxOf(result, zeros + ones)
        }

        return result
    }

    val s = readln()
    println(maxScore(s))
}
