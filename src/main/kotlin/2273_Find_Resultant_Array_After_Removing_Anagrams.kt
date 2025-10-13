fun main() {
    fun removeAnagrams(words: Array<String>): List<String> {
        val result = mutableListOf<String>()
        var prevKey: Int? = null

        for (word in words) {
            val counts = IntArray(26)
            for (ch in word) counts[ch - 'a']++

            val key = counts.contentHashCode()

            if (key != prevKey) {
                result.add(word)
                prevKey = key
            }
        }

        return result
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").toTypedArray()
    println(removeAnagrams(s))
}
