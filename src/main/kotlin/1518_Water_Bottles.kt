fun main() {
    fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
        var full = numBottles
        var empty = 0
        var result = 0
        while (full > 0) {
            empty += full
            result += full
            full = empty / numExchange
            empty %= numExchange
        }
        return result
    }

    val numBottles = readln().toInt()
    val numExchange = readln().toInt()
    println(numWaterBottles(numBottles, numExchange))

}
