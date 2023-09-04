fun main() {
    val s = readln().split(" ").map { it.toInt() }.toIntArray()
    println(applyOperations(s).joinToString())
}

fun applyOperations(nums: IntArray): IntArray {
    for (i in 0 until nums.lastIndex) {
        if (nums[i] == nums[i + 1]) {
            nums[i] *= 2
            nums[i + 1] = 0
        }
    }

    var nonZeroIndex = 0
    for (i in nums.indices) {
        if (nums[i] != 0) {
            nums[nonZeroIndex++] = nums[i]
        }
    }

    for (i in nonZeroIndex..nums.lastIndex) nums[i] = 0

    return nums
}