fun main() {
    fun maximumSumOfHeights(maxHeights: List<Int>): Long {
        var result: Long = 0
        for (maxIndex in maxHeights.indices) {
            var sum: Long = 0
            var max = maxHeights[maxIndex]
            for (i in maxIndex downTo 0) {
                max = max.coerceAtMost(maxHeights[i])
                sum += max
            }
            max = maxHeights[maxIndex]
            for (i in maxIndex + 1 until maxHeights.size) {
                max = max.coerceAtMost(maxHeights[i])
                sum += max
            }
            result = result.coerceAtLeast(sum)
        }

        return result
    }

    val s = readln()
    val array = s
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }
    println(maximumSumOfHeights(array))
}
