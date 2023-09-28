fun main() {
    fun decodeAtIndex(s: String, k: Int): String {
        var size = 0L

        var i = 0
        while (i < s.length) {
            if (s[i].isDigit()) {
                size *= (s[i] - '0')
            } else {
                size++
            }
            i++
            if (size >= k) {
                break
            }
        }
        i--

        var index = k.toLong()
        while (i >= 0) {
            index %= size
            if (index == 0L && s[i].isLetter()) {
                return s[i].toString()
            }
            if (s[i].isDigit()) {
                size /= s[i] - '0'
            } else {
                size--
            }
            i--
        }

        return ""
    }

    val s = readln()
    val k = readln().toInt()
    println(decodeAtIndex(s, k))

//    val matrix = mutableListOf<IntArray>()
//    for (x in s.split("],[")) {
//        val array = x
//            .replace("[", "")
//            .replace("]", "")
//            .replace(",", " ")
//            .split(" ").map { it.toInt() }.toIntArray()
//        matrix.add(array)
//    }
//    println(solve(matrix.toTypedArray()))
}
