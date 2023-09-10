fun main() {
    val s = readln().toInt()
    println(countOrders(s))
}

private fun countOrders(n: Int): Int {
    val mod = 1_000_000_007L
    var result = 1L
    for (i in 1 until n) {
        result *= (i + 1)
        result *= (2 * i + 1)
        result %= mod
    }
    return result.toInt()
}
