fun main() {
    val s = readln().split(" ").map { it.toInt() }.toIntArray()
    println(minimumReplacement(s))
}

fun minimumReplacement(nums: IntArray): Long {
    var result = 0L
    var min = nums.last()
    for (i in nums.lastIndex - 1 downTo 0) {
        val tmp = nums[i]
        if (tmp > min) {
            val count = (tmp - 1) / min
            result += count
            min = tmp / (count + 1)
        } else {
            min = tmp
        }
    }
    return result
}

