fun main() {
    fun transform(it: Int, mapping: IntArray): Int {
        var result = ""
        for (i in it.toString()) {
            result += mapping[i.digitToInt()]
        }
        return result.toInt()
    }

    fun sortJumbled(mapping: IntArray, nums: IntArray): IntArray {
        val result = nums.map { it to transform(it, mapping) }
        return result.sortedBy { it.second }.map { it.first }.toIntArray()
    }

    val mapping = readln().replace("[", "").replace("]", "").split(",").map { it.toInt() }.toIntArray()
    val nums = readln().replace("[", "").replace("]", "").split(",").map { it.toInt() }.toIntArray()
    println(sortJumbled(mapping, nums).joinToString())
}
