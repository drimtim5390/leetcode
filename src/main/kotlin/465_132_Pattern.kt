import java.util.Stack

fun main() {
    fun find132pattern(nums: IntArray): Boolean {
        if (nums.size < 3) return false
        val stack = Stack<Int>()
        val min = IntArray(nums.size)
        min[0] = nums[0]
        for (i in 1..nums.lastIndex) min[i] = nums[i].coerceAtMost(min[i - 1])
        for (j in nums.lastIndex downTo  0) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j]) stack.pop()
                if (!stack.isEmpty() && stack.peek() < nums[j]) return true
                stack.push(nums[j])
            }
        }
        return false
    }

    val s = readln()
    val array = s
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(find132pattern(array))
}
