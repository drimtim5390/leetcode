fun main() {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var max = 0

        while (left < right) {
            val h = if (height[left] > height[right]) height[right] else height[left]

            val v = h * (right - left)
            if (max < v) max = v

            while (height[left] <= h && left < right) left++
            while (height[right] <= h && left < right) right--
        }

        return max
    }

    val height = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(maxArea(height))
}
