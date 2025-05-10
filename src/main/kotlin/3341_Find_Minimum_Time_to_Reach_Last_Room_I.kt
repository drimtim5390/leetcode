import java.util.PriorityQueue

fun main() {
    data class State(val x: Int, val y: Int, val dis: Int) : Comparable<State> {
        override fun compareTo(other: State): Int = this.dis.compareTo(other.dis)
    }

    fun minTimeToReach(moveTime: Array<IntArray>): Int {
        val n = moveTime.size
        val m = moveTime[0].size
        val result = Array(n) { IntArray(m) { Int.MAX_VALUE } }
        val visited = Array(n) { BooleanArray(m) }

        val dirs = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1),
        )

        result[0][0] = 0;

        val queue = PriorityQueue<State>()
        queue.offer(State(0, 0, 0))

        while (queue.isNotEmpty()) {
            val current = queue.poll()
            if (visited[current.x][current.y]) continue
            visited[current.x][current.y] = true

            for (dir in dirs) {
                val x = current.x + dir[0]
                val y = current.y + dir[1]
                if (x !in 0 until n || y !in 0 until m) continue
                val dist = maxOf(result[current.x][current.y], moveTime[x][y]) + 1
                if (result[x][y] > dist) {
                    result[x][y] = dist
                    queue.offer(State(x, y, dist))
                }
            }
        }

        return result[n - 1][m - 1]
    }

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
    println(minTimeToReach(matrix.toTypedArray()))
}
