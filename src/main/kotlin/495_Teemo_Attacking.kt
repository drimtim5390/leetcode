fun main() {
    val s = readln().split(" ").map { it.toInt() }.toIntArray()
    val n = readln().toInt()
    println(findPoisonedDuration(s, n))
}

fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
    var result = 0
    var prev = timeSeries[0] - duration
    timeSeries.forEach {
        result += duration.coerceAtMost(it - prev)
        prev = it
    }
    return result
}

