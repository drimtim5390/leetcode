fun main() {
    fun findTheDifference(s: String, t: String): Char {
        var sum = 0
        for (c in t) sum += c.code
        for (c in s) sum -= c.code
        return sum.toChar()
    }

    val s = readln()
    val t = readln()

    println(findTheDifference(s, t))
}
