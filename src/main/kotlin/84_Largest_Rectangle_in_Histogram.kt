fun main() {
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = IntArray(heights.size + 1)
        var top = 0
        var max = 0

        for (i in 0..heights.size) {
            var height = if (i == heights.size) 0 else heights[i]

            while (top > 0 && height < heights[stack[top - 1]]) {
                val height = heights[stack[--top]]
                val width = if (top == 0) i else i - stack[top - 1] - 1
                max = maxOf(max, width * height)
            }

            stack[top++] = i
        }

        return max
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(largestRectangleArea(s))
}
