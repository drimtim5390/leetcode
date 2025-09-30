fun main() {
    fun triangularSum(nums: IntArray): Int {
        var n = nums.size
        while (n > 1) {
            for (i in 0 until n - 1) {
                nums[i] = (nums[i] + nums[i + 1]) % 10
            }
            n--
        }
        return nums[0]
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(triangularSum(s))
}
