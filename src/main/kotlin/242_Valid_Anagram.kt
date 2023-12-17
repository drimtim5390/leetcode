fun main() {
    fun isAnagram(s: String, t: String): Boolean =
        s.length == t.length && IntArray(26).apply {
            s.forEach { this[it - 'a']++ }
            t.forEach { this[it - 'a']-- }
        }.indexOfFirst { it != 0 } == -1

    val s = readln()
    val t = readln()
    println(isAnagram(s, t))
}
