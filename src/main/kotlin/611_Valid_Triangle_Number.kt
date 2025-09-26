fun main() {
    fun triangleNumber(nums: IntArray): Int {
        var count = 0
        nums.sort()
        for (i in nums.size - 1 downTo 2) {
            var left = 0
            var right = i - 1
            while (right > left) {
                val sum = nums[left] + nums[right]
                if (sum > nums[i]) {
                    count = count + right - left
                    right--
                } else {
                    left++
                }
            }
        }
        return count
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(triangleNumber(s))
}
