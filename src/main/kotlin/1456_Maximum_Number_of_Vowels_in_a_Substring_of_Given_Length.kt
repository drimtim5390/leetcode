fun main() {
    val s = readln()
    val k = readln().toInt()
    println(maxVowels(s, k))
}

private fun maxVowels(s: String, k: Int): Int {
    var vowelCount = 0
    for (i in 0 until k) if (s[i].isVowel()) vowelCount++

    var result = vowelCount
    for (i in k until s.length) {
        if (s[i].isVowel()) vowelCount++
        if (s[i - k].isVowel()) vowelCount--
        result = result.coerceAtLeast(vowelCount)
    }

    return result
}

private fun Char.isVowel(): Boolean {
    return when (this) {
        'a', 'e', 'i', 'o', 'u' -> true
        else -> false
    }
}
