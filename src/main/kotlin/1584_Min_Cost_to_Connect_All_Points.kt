import kotlin.math.abs

fun main() {
    var s = readln()
    val points = mutableListOf<IntArray>()
    while (s.isNotBlank()) {
        points.add(s.split(" ").map { it.toInt() }.toIntArray())
        s = readln()

    }
    println(minCostConnectPoints(points.toTypedArray()))
}

private fun minCostConnectPoints(points: Array<IntArray>): Int {
    var result = 0
    var next = 0
    val nearest = IntArray(points.size) { Integer.MAX_VALUE }
    val visited = mutableSetOf<Int>()
    while (visited.size < points.size) {
        val point = points[next]
        var nextPoint: Int? = null
        var minDistance = Integer.MAX_VALUE
        for (i in points.indices) {
            if (visited.contains(i)) {
                nearest[i] = Integer.MAX_VALUE
                continue
            }
            val curPoint = points[i]
            val distance = abs(curPoint[0] - point[0]) + abs(curPoint[1] - point[1])
            nearest[i] = nearest[i].coerceAtMost(distance)
            if (nextPoint == null || nearest[i] < minDistance) {
                nextPoint = i
                minDistance = nearest[i]
            }
        }
        visited.add(next)
        result += minDistance
        next = nextPoint!!
    }
    return result
}

