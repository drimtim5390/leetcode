fun main() {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val players = IntArray(100001) { -1 }
        val zeros = mutableSetOf<Int>()
        val ones = mutableSetOf<Int>()
        for (match in matches) {
            val winner = match[0]
            if (players[winner] == -1) players[winner] = 0
            if (players[winner] == 0) zeros.add(winner)

            val loser = match[1]
            if (players[loser] == -1) players[loser] = 0
            players[loser]++
            if (players[loser] == 1) {
                zeros.remove(loser)
                ones.add(loser)
            } else {
                ones.remove(loser)
            }
        }
        return listOf(zeros.sorted(), ones.toSet().sorted())
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
    println(findWinners(matrix.toTypedArray()))
}
