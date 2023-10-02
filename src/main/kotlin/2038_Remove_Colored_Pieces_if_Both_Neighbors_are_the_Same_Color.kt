fun main() {
    fun winnerOfGame(colors: String): Boolean {
            var aCount = 0
            var bCount = 0
            for (i in 1 until colors.length - 1) {
                if (colors[i - 1] == colors[i] && colors[i + 1] == colors[i]) {
                    if (colors[i] == 'A') aCount++ else bCount++
                }
            }
            return aCount > bCount
    }

    val s = readln()
    println(winnerOfGame(s))
}
