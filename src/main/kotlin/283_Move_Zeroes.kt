fun main() {
    val s = readln().split(" ").map { it.toInt() }.toIntArray()
    moveZeroes(s)
    println(s.joinToString())
}

fun moveZeroes(nums: IntArray): Unit {
    var nonZeroIndex = 0
    nums.forEachIndexed() { index, value ->
        if (value != 0) nums[nonZeroIndex++] = value
        if (index >= nonZeroIndex) nums[index] = 0
    }
}