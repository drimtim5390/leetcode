fun main() {
    fun minOperations(s: String): Int {
        var startWithZero = 0
        var startWithOne = 0

        for (i in s.indices) {
            val one = s[i].digitToInt() == 1
            val iEven = (i and 1) == 0
            if (one)
                if (iEven) startWithZero++ else startWithOne++
            else
                if (iEven) startWithOne++ else startWithZero++
        }

        return Math.min(startWithZero, startWithOne)
    }

    val s = readln()
    println(minOperations(s))
}
