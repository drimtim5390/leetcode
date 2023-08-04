fun main() {
    val s = readln().split(" ").map { it.toInt() }.toIntArray()
    println(removeDuplicates(s))
    println(s.joinToString())
}

fun removeDuplicates(nums: IntArray): Int {
    nums.distinct()
    var indexToBeCorrected = 0
    var previous = -101
    for (i in nums.indices) {
        if (nums[i] != previous) {
            nums[indexToBeCorrected++] = nums[i]
        }
        previous = nums[i]
    }
    return indexToBeCorrected
}
