import kotlin.math.abs

fun main() {
    val s = readln().split(" ").map { it.toInt() }.toIntArray()
    val points = Array(s.size / 2) { intArrayOf(0, 0) }
    for (i in s.indices step 2) {
        val point = intArrayOf(s[i], s[i + 1])
        points[i / 2] = point
    }
    println(minTimeToVisitAllPoints(points))
}

fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
    var result = 0
    for (i in 1 until points.size) {
        val point = points[i]
        val curr = points[i - 1]
        val diffx = abs(point[0] - curr[0])
        val diffy = abs(point[1] - curr[1])
        result += abs(diffx - diffy) + diffx.coerceAtMost(diffy)
    }
    return result
}

