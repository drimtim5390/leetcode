fun main() {
    fun triangleType(nums: IntArray): String {
        val a = nums[0]
        val b = nums[1]
        val c = nums[2]

        if (a + b <= c || b + c <= a || a + c <= b) return "none"
        if (a == b && b == c) return "equilateral"
        if (a == b || b == c || a == c) return "isosceles"
        return "scalene"
    }

    val nums = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(triangleType(nums))
}
