fun main() {
    fun canBeTypedWords(text: String, brokenLetters: String): Int {
        var result = 0
        val broken = BooleanArray(26)

        for (c in brokenLetters) {
            broken[c - 'a'] = true
        }

        var skipToSpace = false
        var canBeTyped = true
        for (c in text) {
            if (skipToSpace && c != ' ') continue

            if (c == ' ') {
                if (canBeTyped) result++
                skipToSpace = false
                canBeTyped = true
            } else {
                if (broken[c - 'a']) {
                    skipToSpace = true
                    canBeTyped = false
                }
            }
        }
        if (canBeTyped) result++

        return result
    }


    val text = readln()
    val brokenLetters = readln()
    println(canBeTypedWords(text, brokenLetters))
}
