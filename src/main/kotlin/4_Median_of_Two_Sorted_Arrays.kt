fun main() {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val nums = mutableListOf<Int>()
        var index1 = 0
        var index2 = 0

        while(nums.size < nums1.size + nums2.size) {
            if (index1 == nums1.size) {
                while (index2 < nums2.size) {
                    nums.add(nums2[index2++])
                }
                break
            }

            if (index2 == nums2.size) {
                while (index1 < nums1.size) {
                    nums.add(nums1[index1++])
                }
                break
            }

            val num1 = nums1[index1]
            val num2 = nums2[index2]

            if (num1 < num2) {
                nums.add(num1)
                index1++
            } else {
                nums.add(num2)
                index2++
            }
        }

        println(nums.joinToString())

        return if (nums.size % 2 == 0) {
            (nums[(nums.size - 1) / 2] + nums[(nums.size - 1) / 2 + 1]) / 2.0
        } else {
            nums[nums.size / 2] / 1.0
        }
    }

    var s = readln()
    val nums1 = s
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    s = readln()
    val nums2 = s
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()

    println(findMedianSortedArrays(nums1, nums2))
}

