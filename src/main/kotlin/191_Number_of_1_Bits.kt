fun main() {
    fun hammingWeight(s: Int): Int {
        var result = 0
        var n = s
        while (n != 0) {
            result++
            n = n and n - 1
        }
        return result
    }

    val s = readln().toInt()
    println(hammingWeight(s))
}