fun main() {
    val s = readln().split(" ").map { it.toInt() }.toIntArray()
    println(arraySign(s))
}

fun arraySign(nums: IntArray): Int {
    var negatives = 0
    if (nums.any { if (it < 0) negatives++; it == 0 }) return 0
    return if (negatives % 2 == 0) 1 else -1
}

