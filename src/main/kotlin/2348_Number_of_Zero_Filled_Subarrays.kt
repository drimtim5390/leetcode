fun main() {
    fun zeroFilledSubarray(nums: IntArray): Long {
        var result = 0L
        var zeroes = 0L
        for (num in nums) {
            zeroes = if (num == 0) zeroes + 1 else 0
            result += zeroes
        }
        return result
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()

    println(zeroFilledSubarray(s))
}
