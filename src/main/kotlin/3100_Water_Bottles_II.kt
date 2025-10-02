fun main() {
    fun maxBottlesDrunk(numBottles: Int, numExchange: Int): Int {
        var result = 0
        var exc = numExchange
        var full = numBottles
        var empty = 0

        while (full > 0) {
            empty += full
            result += full
            full = 0
            if (empty >= exc) {
                empty -= exc
                full++
                exc++
            }
        }

        return result
    }

    val numBottles = readln().toInt()
    val numExchange = readln().toInt()
    println(maxBottlesDrunk(numBottles, numExchange))
}
