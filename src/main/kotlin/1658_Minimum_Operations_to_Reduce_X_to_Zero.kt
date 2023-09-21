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
    val size = nums.size
    val sums = List(size) { 0 }.toMutableList()
    sums[0] = nums[0]
    for (i in 1..nums.lastIndex) {
        sums[i] = sums[i - 1] + nums[i]
    }

    val last = sums.last()

    if (last == x) {
        return size
    }

    if (last < x) {
        return -1
    }

    var result = Integer.MAX_VALUE
    var leftIndex: Int
    var rightIndex: Int
    var leftSearch: Int
    var rightSearch: Int

    for (i in sums.indices) {
        leftSearch = last - x + sums[i]
        leftIndex = sums.binarySearch(leftSearch, i + 1)

        if (leftIndex >= 0) {
            result = result.coerceAtMost(size - leftIndex + i)
        }

        rightSearch = x - last + sums[size - i - 1]
        rightIndex = sums.binarySearch(rightSearch, 0, size - i - 1)

        if (rightIndex >= 0) {
            result = result.coerceAtMost(rightIndex + i + 1)
        }

        if (rightSearch == 0) {
            result = result.coerceAtMost(i)
        }
    }

    return if (result == Integer.MAX_VALUE) -1 else result
}