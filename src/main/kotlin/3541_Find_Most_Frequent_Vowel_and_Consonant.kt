fun main() {
    fun maxFreqSum(s: String): Int {
        val isVowel = BooleanArray(26)
        isVowel[0] = true
        isVowel[4] = true
        isVowel[8] = true
        isVowel[14] = true
        isVowel[20] = true

        var maxVow = 0
        var maxCon = 0
        val freq = IntArray(26)
        for (c in s) {
            val i = c - 'a'
            freq[i]++
            if (isVowel[i] && maxVow < freq[i]) maxVow = freq[i]
            if (!isVowel[i] && maxCon < freq[i]) maxCon = freq[i]
        }

        return maxVow + maxCon
    }

    val s = readln()
    println(maxFreqSum(s))
}
