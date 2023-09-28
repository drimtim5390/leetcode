import java.util.PriorityQueue

fun main() {
    fun sortArrayByParity(nums: IntArray): IntArray {
        var l = 0
        var r = 0
        while (r < nums.size) {
            if (nums[r] % 2 == 0) {
                if (l != r) {
                    nums[r] += nums[l]
                    nums[l] = nums[r] - nums[l]
                    nums[r] = nums[r] - nums[l]
                }
                l++
            }
            r++
        }
        return nums
    }

    val s = readln()
    val array = s
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(sortArrayByParity(array).joinToString())
}
