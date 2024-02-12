fun main() {
    fun majorityElement(nums: IntArray): Int {
        var count = 0
        var result = 0
        for (num in nums) {
            if (count == 0) result = num
            if (num == result) count++ else count--
        }
        return result
    }

    val s = readln()
    val array = s
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(majorityElement(array))
}
