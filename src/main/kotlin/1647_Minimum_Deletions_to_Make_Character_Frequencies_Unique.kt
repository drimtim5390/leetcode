fun main() {
    val s = readln()
    println(minDeletions(s))
}

private fun minDeletions(s: String): Int {
    val frequencies = IntArray(26)
    var result = 0

    for (c in s) {
        frequencies[c - 'a'] += 1
    }

    frequencies.sort()

    for (index in 0..25) {
        val cur = frequencies[index]
        val prev = frequencies[index - 1]
        when {
            cur == 0 -> break
            prev == 0 -> {
                result += cur
                frequencies[index] = 0
            }
            cur >= prev -> {
                result += cur - prev + 1
                frequencies[index] = prev - 1
            }
        }
    }

    return result
}

