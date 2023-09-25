fun main() {
    fun maximumOddBinaryNumber(s: String): String {
        val count = s.count { it == '1' }
        return "${"1".repeat(count - 1)}${"0".repeat(s.length - count)}1"
    }

    val s = readln()
    println(maximumOddBinaryNumber(s))
}


