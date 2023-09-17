import java.util.PriorityQueue
import kotlin.math.abs

fun main() {
    val s = readln()
    val matrix = mutableListOf<IntArray>()
    for (x in s.split("],[")) {
        val array = x
            .replace("[", "")
            .replace("]", "")
            .replace(",", " ")
            .split(" ").map { it.toInt() }.toIntArray()
        matrix.add(array)
    }
    println(minimumEffortPath(matrix.toTypedArray()))
}

private fun minimumEffortPath(heights: Array<IntArray>): Int {
    val rows = heights.size
    val cols = heights[0].size
    val queue = PriorityQueue<Route>(compareBy({ it.distance }, { -it.order } ))
    var order = 0

    fun calcDistance(from: Pair<Int, Int>, to: Pair<Int, Int>): Int {
        return abs(heights[from.first][from.second] - heights[to.first][to.second])
    }

    fun offerQueue(route: Route, first: Int, second: Int) {
        if (first !in 0 until rows || second !in 0 until cols) {
            return
        }
        if (route.visited.contains("$first$second")) {
            return
        }
        val next = Pair(first, second)
        val distance = calcDistance(route.lastPoint, next).coerceAtLeast(route.distance)
        val visited = route.visited + "$first$second"
        queue.offer(Route(next, visited, distance, order++))
    }

    var result = Integer.MAX_VALUE

    queue.add(Route(Pair(rows - 1, cols - 1), setOf("${rows - 1}${cols - 1}"), 0, order++))

    do {
        val route = queue.poll()
        val start = route.lastPoint
        if (start.first == 0 && start.second == 0) {
            result = result.coerceAtMost(route.distance)
            continue
        }
        offerQueue(route, start.first, start.second + 1)
        offerQueue(route, start.first + 1, start.second)
        offerQueue(route, start.first, start.second - 1)
        offerQueue(route, start.first - 1, start.second)
    } while (queue.size > 0 && queue.peek().distance < result)

    return result
}

class Route(
    val lastPoint: Pair<Int, Int>,
    val visited: Set<String>,
    val distance: Int,
    val order: Int
)

//1 2 1 1 1
//1 2 1 2 1
//1 2 1 2 1
//1 2 1 2 1
//1 1 1 2 1

