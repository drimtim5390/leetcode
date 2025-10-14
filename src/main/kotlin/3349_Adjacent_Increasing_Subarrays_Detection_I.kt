fun main() {
    fun hasIncreasingSubarrays(nums: List<Int>, k: Int): Boolean {
        var prevStreak = 0
        var currentStreak = 1
        for (i in 1 until nums.size) {
            if (nums[i] > nums[i - 1]) currentStreak++
            else {
                prevStreak = currentStreak
                currentStreak = 1
            }
            if (currentStreak / 2 >= k) return true
            if (currentStreak >= k && prevStreak >= k) return true
        }
        return false
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }
    val k = readln().toInt()
    println(hasIncreasingSubarrays(s, k))
}
