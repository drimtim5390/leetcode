import kotlin.math.max

fun main() {
    fun minTime(skill: IntArray, mana: IntArray): Long {
        val n = skill.size
        val m = mana.size

        val done = LongArray(n + 1)

        for (j in 0 until m) {
            for (i in 0 until n) {
                done[i + 1] = max(done[i + 1], done[i]) + mana[j] * skill[i]
            }
            for (i in n - 1 downTo 1) {
                done[i] = done[i + 1] - mana[j] * skill[i]
            }
        }

        return done[n]
    }

    val skill = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    val mana = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(minTime(skill, mana))
}
