fun main() {
    val s = readln().split(" ").map { it.toInt() }.toIntArray()
    println(maxProductDifference(s))
}

private fun maxProductDifference(nums: IntArray): Int {
    var w = Integer.MIN_VALUE
    var x = Integer.MIN_VALUE
    var y = Integer.MAX_VALUE
    var z = Integer.MAX_VALUE

    for (num in nums) {
        when {
            w < num -> {
                x = w
                w = num
            }
            num in (x + 1)..w -> x = num
        }

        when {
            z > num -> {
                y = z
                z = num
            }
            num in z..<y -> y = num
        }
    }

    return w * x - y * z
}

