fun main() {
    fun missingNumber(nums: IntArray) = nums.size.let { (1 + it) * it / 2 - nums.sum() }

    val s = readln()
    val array = s
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(missingNumber(array))
}
