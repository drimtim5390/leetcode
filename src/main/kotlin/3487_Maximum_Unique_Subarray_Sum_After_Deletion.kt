fun main() {
    fun maxSum(nums: IntArray): Int {
        var result = 0
        var max = nums[0]
        val set = mutableSetOf<Int>()
        for (num in nums) {
            if (num > max) max = num
            if (num >= 0 && !set.contains(num)) {
                set += num
                result += num
            }
        }
        return if (set.isEmpty()) max else result
    }

    val s = readln().replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()

    println(maxSum(s))
}
