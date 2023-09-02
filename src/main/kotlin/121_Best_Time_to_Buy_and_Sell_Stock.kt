fun main() {
    val s = readln().split(" ").map { it.toInt() }.toIntArray()
    println(maxProfit(s))
}

fun maxProfit(prices: IntArray): Int {
    var result = 0
    var min = prices[0]
    prices.forEach {
        min = min.coerceAtMost(it)
        result = result.coerceAtLeast(it - min)
    }
    return result
}


