fun main() {
    fun minimumDeletions(s: String): Int {
        var min = 0
        var b = 0
        for (c in s) {
            if (c == 'b') {
                b++
            } else {
                min = b.coerceAtMost(min + 1)
            }
        }
        return min
    }

    val s = readln()
    println(minimumDeletions(s))
}
