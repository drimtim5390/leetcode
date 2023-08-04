fun main() {
    val s = readln().split(" ").map { it.toInt() }.toIntArray()
    val n = readln().toInt()
    println(removeElement(s, n))
    println(s.joinToString())
}

fun removeElement(nums: IntArray, `val`: Int): Int {
    var k = 0
    nums.forEach { if (it != `val`) nums[k++] = it }
    return k
}