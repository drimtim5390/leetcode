fun main() {
    fun countHillValley(nums: IntArray): Int {
        var result = 0
        var last = nums[0]

        for (i in 1 until nums.lastIndex) {
            if (nums[i] != nums[i + 1]) {
                if (
                    (nums[i] > last && nums[i] > nums[i + 1]) ||
                    (nums[i] < last && nums[i] < nums[i + 1])
                ) result++
                last = nums[i]
            }
        }

        return result
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }
        .toIntArray()

    println(countHillValley(s))
}
