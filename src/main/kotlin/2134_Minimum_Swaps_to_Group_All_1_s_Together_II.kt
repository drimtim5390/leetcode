fun main() {
    fun minSwaps(nums: IntArray): Int {
        val count = nums.count { it == 1 }
        var sum = 0
        var result = 0
        for (i in 0 until (nums.size * 2 - 1)) {
            val new = i % nums.size
            val old = (i - count) % nums.size
            sum += nums[new]
            if (i >= count) {
                sum -= nums[old]
            }
            result = maxOf(result, sum)
        }
        return count - result
    }

    val nums = readln().replace("[", "").replace("]", "").split(",").map { it.toInt() }.toIntArray()
    println(minSwaps(nums))
}
