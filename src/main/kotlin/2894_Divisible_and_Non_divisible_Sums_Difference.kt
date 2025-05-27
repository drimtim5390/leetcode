fun main() {
    fun differenceOfSums(n: Int, m: Int): Int {
        val sum = (n + 1) * n / 2
        val diff = n / m
        val sub = (m + diff * m) * diff
        return sum - sub
    }

    val n = readln().toInt()
    val m = readln().toInt()
    println(differenceOfSums(n, m))
}
