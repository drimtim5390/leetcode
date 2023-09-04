fun main() {
    val s = readln()
    val n = readln().toInt()
    println(convert(s, n))
}

fun convert(s: String, numRows: Int): String {
    if (numRows == 1) return s
    val result = StringBuilder("")
    for (i in 0 until numRows) {
        for (j in 0..(s.length + numRows) step (numRows - 1) * 2) {
            if (j - i >= 0 && j - i < s.length) result.append(s[j - i])
            if (i != numRows - 1 && i != 0 && j + i < s.length) result.append(s[j + i])
        }
    }
    return result.toString()
}

