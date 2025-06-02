fun main() {
    fun candy(ratings: IntArray): Int {
        val candies = IntArray(ratings.size) { 1 }

        for (i in 1 until candies.size) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1
            }
        }

        var result = candies[candies.size - 1]
        for (i in candies.size - 2 downTo 0) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1
            }
            result += candies[i]
        }

        return result
    }

    val s = readln().split(" ").map { it.toInt() }.toIntArray()
    println(candy(s))
}
