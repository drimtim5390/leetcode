fun main() {
    val x = readln().toInt()
    println(mySqrt(x))
}

fun mySqrt(x: Int): Int {
    var left = 0
    var right = x / 2 + 1
    while (left <= right) {
        val mid = (left + right) / 2
        if (x / mid == mid) {
            return mid
        } else if (mid > x / mid) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return right
}
