fun main() {
    fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
        val sums = mutableListOf<Int>()
        for (i in nums.indices) {
            for (j in i..nums.lastIndex) {
                var sum = 0
                for (k in i..j) {
                    sum += nums[k]
                }
                sums.add(sum)
            }
        }
        sums.sort()
        var result = 0
        for (i in left - 1..<right) {
            result = (result % 1000000007) + (sums[i] % 1000000007)
        }
        return result
    }

    val nums = readln().replace("[", "").replace("]", "").split(",").map { it.toInt() }.toIntArray()
    val n = readln().toInt()
    val left = readln().toInt()
    val right = readln().toInt()
    println(rangeSum(nums, n, left, right))
}
