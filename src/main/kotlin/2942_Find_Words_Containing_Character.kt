fun main() {
    fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
        val result = mutableListOf<Int>()
        for ((i, w) in words.withIndex()) {
            for (c in w) {
                if (c == x) {
                    result += i
                    break
                }
            }
        }
        return result
    }

    val words = readln()
        .replace("[", "")
        .replace("]", "")
        .replace("\"", "")
        .replace(",", " ")
        .split(" ").toTypedArray()
    val char = readln()

    println(findWordsContaining(words, char[0]))


}
