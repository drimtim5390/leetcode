package solving//fun main() {
//    val s = readln().split(" ").map { it.toInt() }.toIntArray()
//    println(subArrayRanges(s))
//}
//
//fun subArrayRanges(nums: IntArray): Long {
//    var result = 0L
//    val mins = Array(nums.size) { IntArray(nums.size) { Integer.MAX_VALUE } }
//    val maxs = Array(nums.size) { IntArray(nums.size) { Integer.MIN_VALUE } }
//    for (i in 2..nums.size) {
//        for (j in 0..(nums.size - i)) {
//            var min = nums[j]
//            var max = nums[j]
//            for (k in j until (j + i)) {
//                val it = nums[k]
//                if (min > it) min = it
//                if (max < it) max = it
//            }
//            result += (max - min)
//
//            fun minBetween(start: Int, size: Int): Int {
//                if (mins[start][start + size] != Integer.MAX_VALUE) return mins[start][start + size]
//            }
//        }
//    }
//    return result
//}
//
