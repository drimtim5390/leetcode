fun main() {
    val s1 = readln().split(" ").map { it.toInt() }.toIntArray()
    val s2 = readln().split(" ").map { it.toInt() }.toIntArray()
    println(findDifference(s1, s2))
}

private fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val result = List<MutableSet<Int>>(2) { mutableSetOf() }
    val mapFirstArray = mutableMapOf<Int, Int>()
    val mapSecondArray = mutableMapOf<Int, Int>()
    for (num in nums1) {
        mapFirstArray[num] = 1
    }
    for (num in nums2) {
        if (!mapFirstArray.containsKey(num)) {
            result[1].add(num)
        }
        mapSecondArray[num] = 1
    }
    for (num in nums1) {
        if (!mapSecondArray.containsKey(num)) {
            result[0].add(num)
        }
    }
    return result.map { it.toList() }
}

