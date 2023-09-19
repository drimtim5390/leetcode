import java.lang.StringBuilder

fun main() {
    val s = readln()
    val array = s
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(findDuplicate(array))
}

private fun findDuplicate(nums: IntArray): Int {
    val numbers = BooleanArray(nums.size)
    for (num in nums) {
        if (numbers[num - 1]) {
            return num
        }
        numbers[num - 1] = true
    }
    return 1
}

