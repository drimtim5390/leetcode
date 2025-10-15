fun main() {
    fun maxIncreasingSubarrays(nums: List<Int>): Int {
        val n = nums.size
        val incFromLeft = IntArray(n) { 1 }
        val incFromRight = IntArray(n) { 1 }
        for (i in 1 until n - 1) {
            if (nums[i] > nums[i - 1]) incFromLeft[i] = incFromLeft[i - 1] + 1
            if (nums[n - i - 1] < nums[n - i]) incFromRight[n - i - 1] = incFromRight[n - i] + 1
        }
        var result = 1
        for (i in 0 until n - 1) {
            result = maxOf(result, minOf(incFromRight[i + 1], incFromLeft[i]))
        }
        return result
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }
    println(maxIncreasingSubarrays(s))
}
