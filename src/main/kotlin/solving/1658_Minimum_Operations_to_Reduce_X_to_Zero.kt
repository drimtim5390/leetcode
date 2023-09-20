package solving

fun main() {
    val s = readln()
    val nums = s
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    val x = readln().toInt()
    println(minOperations(nums, x))
}

private fun minOperations(nums: IntArray, x: Int): Int {
    var result = -1
    var target = 0
    var sum = 0
    var left = 0

    if (nums.sum().let {
            if (it < x) return@let true
            if (it == x) result = nums.size
            target = it - x
            return@let false
        }) {
        return -1
    }

    if (result != -1) {
        return result
    }

    for (right in nums.indices) {
        sum += nums[right]

        while (left <= right && sum > target) sum -= nums[left++]
        if (target == sum) result = result.coerceAtLeast(right - left + 1)
    }

    return if (result == -1) -1 else nums.size - result
}

