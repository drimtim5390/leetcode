fun main() {
    fun sortArray(nums: IntArray): IntArray {
        val counter = IntArray(100001)
        for (num in nums) {
            counter[num + 50000]++
        }
        val result = mutableListOf<Int>()
        for (i in counter.indices) {
            for (j in 0 until counter[i]) {
                result.add(i - 50000)
            }
        }
        return result.toIntArray()
    }

    val nums = readln().replace("[", "").replace("]", "").split(",").map { it.toInt() }.toIntArray()
    println(sortArray(nums).joinToString())
}
