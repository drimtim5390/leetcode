fun main() {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        var consec = 0
        for (num in arr) {
            if (num % 2 == 1) {
                consec++
            } else {
                consec = 0
            }
            if (consec == 3) {
                return true
            }
        }
        return false
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()

    println(threeConsecutiveOdds(s))
}
