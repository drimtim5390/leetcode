fun main() {
    fun sortVowels(s: String): String {
        val map = mapOf(
            'A' to 0,
            'E' to 1,
            'I' to 2,
            'O' to 3,
            'U' to 4,
            'a' to 5,
            'e' to 6,
            'i' to 7,
            'o' to 8,
            'u' to 9,
        )
        val mapV = mapOf(
            0 to 'A',
            1 to 'E',
            2 to 'I',
            3 to 'O',
            4 to 'U',
            5 to 'a',
            6 to 'e',
            7 to 'i',
            8 to 'o',
            9 to 'u',
        )
        val vowels = IntArray(10)
        for (c in s) {
            if (map.containsKey(c)) vowels[map[c]!!]++
        }
        var index = 0
        val result = StringBuilder()
        for (c in s) {
            if (map.containsKey(c)) {
                while (vowels[index] <= 0) {
                    index++
                }
                vowels[index]--
                result.append(mapV[index]!!)
            } else {
                result.append(c)
            }
        }

        return result.toString()
    }

    val s = readln()
    println(sortVowels(s))
}
