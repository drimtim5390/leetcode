fun main() {
    val s = readln()
    println(lengthOfLongestSubstring(s))
}

fun lengthOfLongestSubstring(s: String): Int {
    var result = 0
    var start = 0
    val charMap = HashMap<Char, Int>()
    for ((index, char) in s.withIndex()) {
        val prevIndex = charMap[char]
        charMap[char] = index
        if (prevIndex != null && prevIndex >= start) {
            start = prevIndex + 1
            continue
        }
        result = result.coerceAtLeast(index - start + 1)
    }
    return result
}

