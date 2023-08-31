fun main() {
    val n = readln().toInt()
    val ranges = readln().replace("[", "").replace("]", "").replace(",", " ").split(" ").map { it.toInt() }.toIntArray()
    println(minTaps(n, ranges))
}

fun minTaps(n: Int, ranges: IntArray): Int {
    var last = 0
    var result = 0

    while (last < n) {
        var max = last
        ranges.forEachIndexed {index, it ->
            val start = index - it
            val end = index + it
            if (last in start..end && end >= max) {
                max = end
            }
        }

        if (max == last) return -1
        last = max
        result++
    }

    return result
}
