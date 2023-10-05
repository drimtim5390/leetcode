fun main() {
    fun majorityElement(nums: IntArray): List<Int> {
        val limit = nums.size / 3
        val map = mutableMapOf<Int, Int>()
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }
        return map.filter { it.value > limit }.map { it.key }.toList()
    }

    val s = readln()
    val array = s
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(majorityElement(array))
}
