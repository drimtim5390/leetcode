fun main() {
    fun frequencySort(nums: IntArray): IntArray {
        val frequencies = mutableMapOf<Int, Int>()
        for (num in nums) {
            frequencies[num] = frequencies.getOrDefault(num, 0) + 1
        }
        val pairs = mutableListOf<Pair<Int, Int>>()
        for (num in nums) {
            pairs.add(num to frequencies[num]!!)
        }
        return pairs.sortedWith(compareBy({ it.second }, { -it.first })).map { it.first }
            .toIntArray()
    }

    val nums = readln().replace("[", "").replace("]", "").split(",").map { it.toInt() }.toIntArray()
    println(frequencySort(nums).joinToString())
}
