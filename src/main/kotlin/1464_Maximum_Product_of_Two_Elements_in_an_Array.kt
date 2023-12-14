fun main() {
    fun maxProduct(nums: IntArray): Int {
        var result = (nums[0] - 1) * (nums[1] - 1)
        for (i in nums.indices) {
            for (j in (i + 1 until nums.size)) {
                result = result.coerceAtLeast((nums[i] - 1) * (nums[j] - 1))
            }
        }
        return result
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(maxProduct(s))

//    val matrix = mutableListOf<IntArray>()
//    for (x in s.split("],[")) {
//        val array = x
//            .replace("[", "")
//            .replace("]", "")
//            .replace(",", " ")
//            .split(" ").map { it.toInt() }.toIntArray()
//        matrix.add(array)
//    }
//    println(solve(matrix.toTypedArray()))
}
