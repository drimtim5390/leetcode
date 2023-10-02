fun main() {
    fun reverseWords(s: String) = s.split(" ").joinToString(" ") { it.reversed() }

    val s = readln()
    println(reverseWords(s))
}
