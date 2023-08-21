fun main() {
    val s = readln()
    println(repeatedSubstringPattern(s))
}

fun repeatedSubstringPattern(s: String): Boolean =
    when (s.length) {
        0, 1 -> false
        2 -> s[0] == s[1]
        else -> "${s.substring(1)}${s.substring(0, s.length - 1)}".contains(s)
    }

