fun main() {
    fun findSmallestInteger(nums: IntArray, value: Int): Int {
        val counts = IntArray(value)
        for (num in nums) {
            var mod = num % value
            if (mod < 0) mod += value
            counts[mod]++
        }
        var max = Int.MAX_VALUE
        var maxMod = 0
        for (i in 0..<value)
            if (counts[i] < max) {
                maxMod = i
                max = counts[i]
            }

        return value * max + maxMod
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    val k = readln().toInt()
    println(findSmallestInteger(s, k))
}
