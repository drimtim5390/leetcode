fun main() {
    fun maximumEnergy(energy: IntArray, k: Int): Int {
        val n = energy.size
        var max = energy[n - 1]
        for (i in n - 1 downTo 0) {
            if (i + k in 0 until n) {
                energy[i] += energy[i + k]
            }
            if (energy[i] > max) max = energy[i]
        }
        return max
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    val k = readln().toInt()
    println(maximumEnergy(s, k))
}
