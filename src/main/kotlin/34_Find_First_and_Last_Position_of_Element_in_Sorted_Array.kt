fun main() {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val result = IntArray(2) { -1 }

        var l = 0
        var r = nums.lastIndex
        while (l <= r) {
            val mid = l + (r - l) / 2
            if (nums[mid] == target) {
                result[0] = mid
                r = mid - 1
            } else if (nums[mid] < target) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }

        if (result[0] == -1) return result

        l = result[0]
        r = nums.lastIndex
        while (l <= r) {
            val mid = l + (r - l) / 2
            if (nums[mid] == target) {
                result[1] = mid
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        System.gc()
        return result
    }

    val s = readln()
    val k = readln().toInt()
    val array = s
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(searchRange(array, k).joinToString())
}
