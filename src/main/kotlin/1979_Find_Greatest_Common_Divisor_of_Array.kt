fun main() {
    val s = readln().split(" ").map { it.toInt() }.toIntArray()
    println(findGCD(s))
}

fun findGCD(nums: IntArray): Int {
    var max = nums[0]
    var min = nums[0]

    nums.forEach {
        if (it < min) min = it
        if (it > max) max = it
    }

    return gcd(min, max)
}

fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

