fun main() {
    fun isMonotonic(nums: IntArray): Boolean {
        var isInc: Boolean? = null

        for (i in 1 until nums.size) {
            if (nums[i - 1] == nums[i]) continue
            if (isInc == null) isInc = nums[i] > nums[i - 1]
            if (isInc && nums[i] < nums[i - 1]) return false
            if (!isInc && nums[i] > nums[i - 1]) return false
        }

        return true
    }

    val s = readln()
    val array = s
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(isMonotonic(array))

}
