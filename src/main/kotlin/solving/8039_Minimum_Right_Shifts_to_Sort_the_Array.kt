package solving

fun main() {
    val s = readln().split(" ").map { it.toInt() }
    println(minimumRightShifts(s))
}

private fun minimumRightShifts(nums: List<Int>): Int {
    if (nums.size == 1) return 0
    val s = nums + nums
    var shifts = 0
    var count = 0
    for (i in 0 until s.size - 1) {
        if (s[i] > s[i + 1]) {
            shifts++
        }
        if (shifts == 2) {
            count++
        }
    }
    return when (shifts) {
        1 -> 0
        2 -> count
        else -> -1
    }
}

