fun main() {
    val s = readln()
    val n = readln()
    println(strStr(s, n))
}

fun strStr(haystack: String, needle: String): Int {
    for (i in 0..(haystack.length - needle.length)) {
        if (haystack.substring(i, i + needle.length) == needle) {
            return i
        }
    }
    return -1
}