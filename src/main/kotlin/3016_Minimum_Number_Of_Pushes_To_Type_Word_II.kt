fun main() {
    fun minimumPushes(word: String): Int {
        val letters = IntArray(26) { 0 }
        for (i in word.indices) {
            letters[word[i].code - 97]++
        }
        letters.sortDescending()
        var result = 0
        for (i in letters.indices) {
            result += if (i < 8) letters[i]
            else if (i < 16) 2 * letters[i]
            else if (i < 24) 3 * letters[i]
            else 4 * letters[i]
        }
        return result
    }

    val word = readln().replace("\"", "")
    println(minimumPushes(word))
}
