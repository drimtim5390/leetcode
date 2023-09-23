fun main() {
    val s = readln()
    val array = s
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").toTypedArray()

    fun longestStrChain(words: Array<String>): Int {
        fun wordsAreChained(word1: String, word2: String): Boolean {
            if (word2.length - word1.length != 1) return false
            var i1 = 0
            var i2 = 0
            while (i1 < word1.length && i2 < word2.length) {
                if (word1[i1] == word2[i2]) {
                    i1++
                }
                if (i1 == word1.length) {
                    return true
                }
                i2++
            }
            return false
        }

        var result = 1
        val wordChains = IntArray(words.size) { 1 }
        words.sortByDescending { it.length }
        for (i in words.indices) {
            val word = words[i]
            var index = i - 1
            while (index >= 0) {
                if (wordsAreChained(word, words[index])) {
                    wordChains[i] = wordChains[i].coerceAtLeast(wordChains[index] + 1)
                }
                index--
            }
            result = result.coerceAtLeast(wordChains[i])
        }
        return result
    }

    println(longestStrChain(array))
}

