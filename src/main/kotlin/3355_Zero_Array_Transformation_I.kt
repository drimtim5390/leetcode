fun main() {
    fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
        val diffArray = IntArray(nums.size + 1)

        for (query in queries) {
            diffArray[query[0]]++
            diffArray[query[1] + 1]--
        }

        var sum = 0
        for (i in nums.indices) {
            sum += diffArray[i]
            if (sum < nums[i]) {
                return false
            }
        }

        return true
    }

    val nums = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()

    val s = readln()
    val queries = mutableListOf<IntArray>()
    for (x in s.split("],[")) {
        val array = x
            .replace("[", "")
            .replace("]", "")
            .replace(",", " ")
            .split(" ").map { it.toInt() }.toIntArray()
        queries.add(array)
    }
    println(isZeroArray(nums, queries.toTypedArray()))
}
