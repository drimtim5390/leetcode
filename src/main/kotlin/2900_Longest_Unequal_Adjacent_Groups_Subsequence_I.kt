fun main() {
    fun getLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
        var last = -1
        val result = mutableListOf<String>()
        for (i in 0 until groups.size) {
            if (groups[i] != last) {
                last = groups[i]
                result += words[i]
            }
        }
        return result
    }

    val words = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").toTypedArray()
    val groups = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(getLongestSubsequence(words, groups))
}
