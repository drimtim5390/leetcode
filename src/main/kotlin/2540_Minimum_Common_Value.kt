fun main() {
    fun getCommon(nums1: IntArray, nums2: IntArray): Int {
        nums1.forEach {
            if (nums2.contains(it)) return it
        }
        return -1
    }

    println(getCommon(intArrayOf(1,2,3,4), intArrayOf(3,4,5)))
}
