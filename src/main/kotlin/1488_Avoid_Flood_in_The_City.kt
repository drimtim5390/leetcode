fun main() {
    fun avoidFlood(rains: IntArray): IntArray {
        val result = IntArray(rains.size)
        val drainIndex = sortedSetOf<Int>()
        val fullLakes = mutableMapOf<Int, Int>()
        for (i in 0 until rains.size) {
            val rain = rains[i]
            if (rain != 0) {
                if (fullLakes.contains(rain)) {
                    val filled = fullLakes[rain]!!
                    val drain = drainIndex.firstOrNull { it in filled until i }
                    if (drain == null) return intArrayOf()
                    result[drain] = rain
                    drainIndex.remove(drain)
                }
                fullLakes[rain] = i
                result[i] = -1
                continue
            }
            result[i] = 1
            drainIndex.add(i)
        }
        return result
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(avoidFlood(s).toList())
}
