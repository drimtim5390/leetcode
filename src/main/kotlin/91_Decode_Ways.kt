fun main() {
    val map = mutableMapOf<String, Int>()

    fun countPossibilities(s: String): Int {
        if (map.contains(s)) return map[s]!!
        var result = 0
        if (s[0] != '0')
            if (s.length > 2) {
                result = countPossibilities(s.substring(1))
                if (s.substring(0, 2).toInt() <= 26) {
                    result += countPossibilities(s.substring(2))
                }
            } else {
                if (s.length == 1) result++
                if (s.length > 1 && s[1] != '0') result++
                if (s.length > 1 && s.toInt() in 1..26) result++
            }
        if (!map.contains(s)) map[s] = result
        return result
    }

    fun numDecodings(s: String): Int {
        return countPossibilities(s)
    }

    val s = readln()
    println(numDecodings(s))
}
