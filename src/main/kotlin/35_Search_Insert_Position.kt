fun main() {
    val nums = readln().split(" ").map { it.toInt() }.toIntArray()
    val target = readln().toInt()
    println(searchInsert(nums, target))
}

fun searchInsert(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.lastIndex
    while (left <= right) {
        val mid = (left + right) / 2
        when {
            target == nums[mid] -> return mid
            target < nums[mid] -> right = mid - 1
            target > nums[mid] -> left = mid + 1
        }
    }
    return left
}

