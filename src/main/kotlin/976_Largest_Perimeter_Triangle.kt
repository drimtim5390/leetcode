import java.util.PriorityQueue

fun main() {
    fun largestPerimeter(nums: IntArray): Int {
        val pq = PriorityQueue<Int>({ a, b -> if (a < b) 1 else -1 })

        for (n in nums) pq.add(n)

        while (pq.size >= 3) {
            val a = pq.poll()
            val b = pq.poll()
            val c = pq.poll()
            if (a < b + c) return a + b + c
            pq.add(b)
            pq.add(c)
        }

        return 0
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(largestPerimeter(s))
}
