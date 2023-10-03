fun main() {
    fun numIdenticalPairs(nums: IntArray): Int {
        var result = 0
        for (i in 0 until nums.size - 1)
            for (j in i + 1 until nums.size)
                if (nums[i] == nums[j]) result++
        return result
    }

    val s = readln()
    val array = s
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(numIdenticalPairs(array))
}
