fun main() {
    fun doesAliceWin(s: String): Boolean {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        val count = s.count { it in vowels }
        return count != 0
    }

    val s = readln()
    println(doesAliceWin(s))
}
