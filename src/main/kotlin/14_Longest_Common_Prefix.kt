fun main() {
    val s = readln().split(" ")
    println(longestCommonPrefix(s.toTypedArray()))
}

fun longestCommonPrefix(words: Array<String>): String {
    words.sort()
    val firstWord = words.first()
    val lastWord = words.last()
    var result = ""
    var i = 0
    while (i < firstWord.length && i < lastWord.length) {
        if (firstWord[i] == lastWord[i]) {
            result += firstWord[i]
        } else {
            break
        }
        i++
    }
    return result
}