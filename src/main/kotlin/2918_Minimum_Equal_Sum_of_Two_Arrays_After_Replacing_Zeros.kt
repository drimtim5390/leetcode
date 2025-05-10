fun main() {
    fun minSum(nums1: IntArray, nums2: IntArray): Long {
        var sum1: Long = 0
        var sum2: Long = 0
        var zero1 = 0
        var zero2 = 0

        for (num in nums1) {
            sum1 += num
            if (num == 0) {
                sum1++
                zero1++
            }
        }

        for (num in nums2) {
            sum2 += num
            if (num == 0) {
                sum2++
                zero2++
            }
        }

        if ((zero1 == 0 && sum2 > sum1) || (zero2 == 0 && sum1 > sum2)) {
            return -1
        }

        return maxOf(sum1, sum2)
    }

    val nums1 = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    val nums2 = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(minSum(nums1, nums2))
}
