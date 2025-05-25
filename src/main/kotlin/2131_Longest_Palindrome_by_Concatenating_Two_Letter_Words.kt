fun main() {
    fun longestPalindrome(words: Array<String>): Int {
        val countMap = words.groupingBy { it }.eachCount().toMutableMap()
        var odd = false
        var result = 0

        for ((char, count) in countMap) {
            if (char[0] == char[1]) {
                result += count / 2 * 4
                countMap[char] = count % 2
                if (countMap[char] == 1) odd = true
            } else {
                val tmp = char[1] + "" + char[0]
                if (countMap.containsKey(tmp)) {
                    val min = minOf(countMap[tmp]!!, count)
                    result += min * 4
                    countMap[tmp] = countMap[tmp]!! - min
                    countMap[char] = countMap[char]!! - min
                }
            }
        }
        if (odd) result += 2
        return result
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace("\"", "")
        .replace(",", " ")
        .split(" ").toTypedArray()
    println(longestPalindrome(s))
}
