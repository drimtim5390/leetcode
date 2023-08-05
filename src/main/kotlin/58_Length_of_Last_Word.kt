fun main() {
    val s = readln()
    println(lengthOfLastWord(s))
}

fun lengthOfLastWord(s: String): Int {
    var wordLength = 0
    var lastWordLength = 0
    for (c in s) {
        if (c == ' ') {
            wordLength = 0
        } else {
            wordLength++
        }
        if (wordLength > 0) {
            lastWordLength = wordLength
        }
    }
    return lastWordLength
}

