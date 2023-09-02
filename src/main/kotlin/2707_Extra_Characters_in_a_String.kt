fun main() {
    val s = readln()
    val dictionary = readln().split(" ").toTypedArray()
    println(minExtraChar(s, dictionary))
}

fun minExtraChar(s: String, dictionary: Array<String>): Int {
    val resultMap = IntArray(s.length + 1) { -1 }
    (s.lastIndex downTo 0).forEach {
        val tmp = s.substring(it)
        resultMap[tmp.length] = countMinSkipped(tmp, dictionary, resultMap)
    }
    return resultMap[s.length]
}

fun countMinSkipped(s: String, dictionary: Array<String>, resultMap: IntArray): Int {
    if (resultMap[s.length] != -1) {
        return resultMap[s.length]
    }
    var result = s.length
    dictionary.forEach { word ->
        if (s.startsWith(word)) {
            result = result.coerceAtMost(countMinSkipped(s.substring(word.length), dictionary, resultMap))
        }
    }
    if (s.length > 1) {
        result = result.coerceAtMost(1 + countMinSkipped(s.substring(1), dictionary, resultMap))
    }
    resultMap[s.length] = result
    return result
}
