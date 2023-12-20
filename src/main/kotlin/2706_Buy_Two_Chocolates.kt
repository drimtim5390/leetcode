fun main() {
    fun buyChoco(prices: IntArray, money: Int): Int {
        if (prices.size <= 1) {
            return money
        }
        var first = Int.MAX_VALUE
        var second = Int.MAX_VALUE

        for (price in prices) {
            when {
                first >= price -> {
                    second = first
                    first = price
                }

                second >= price -> {
                    second = price
                }
            }
        }
        return if (money < first + second) money else money - first - second
    }

    val money = readln().toInt()
    val prices = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()

    println(buyChoco(prices, money))
}
