package solving

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val s = Array(m) { intArrayOf(0, 0) }
    for (i in 0 until m) {
        s[i] = readln().split(" ").map { it.toInt() }.toIntArray()
    }
    println(maximalNetworkRank(n, s))
}

fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
    val mentions = mutableMapOf<Int, Int>()
    val map = mutableMapOf<Int, MutableSet<Int>>()

    for (i in 0 until n) {
        mentions[i] = 0
        map[i] = mutableSetOf()
    }
    for (road in roads) {
        map[road[0]].apply { this!!.add(road[1]) }
        map[road[1]].apply { this!!.add(road[0]) }
        mentions[road[0]] = mentions[road[0]]!! + 1
        mentions[road[1]] = mentions[road[1]]!! + 1
    }

    val sortedMentions = mentions.entries.sortedByDescending { it.value }
    val max1 = sortedMentions[0]
    val max2 = sortedMentions[1]
    return max1.value + max2.value - (if (map[max1.key]!!.contains(max2.key)) 1 else 0)
}

