import kotlin.math.ceil

fun main() {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        val n = spells.size
        val m = potions.size

        val result = IntArray(n)

        potions.sort()
        val maxP = potions[m - 1]

        for ((i, spell) in spells.withIndex()) {
            val threshold = ceil(success.toDouble() / spell).toInt()

            if (threshold > maxP) {
                result[i] = 0
                continue
            }

            var left = 0
            var right = m

            while (left < right) {
                val mid = left + (right - left) / 2
                if (potions[mid] < threshold) left = mid + 1
                else right = mid
            }

            result[i] = m - left
        }
        return result
    }

    val spells = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    val potions = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    val success = readln().toLong()
    println(successfulPairs(spells, potions, success).toList())
}
