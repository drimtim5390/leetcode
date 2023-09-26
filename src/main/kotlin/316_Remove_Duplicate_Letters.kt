import java.util.*

fun main() {

    fun removeDuplicateLetters(s: String): String {
        val lastOcc = mutableMapOf<Char, Int>()
        val stack = Stack<Char>()
        val visited = mutableSetOf<Char>()

        for (i in s.indices) {
            lastOcc[s[i]] = i
        }

        for (i in s.indices) {
            if (s[i] !in visited) {
                while (!stack.isEmpty() && stack.peek() > s[i] && lastOcc[stack.peek()]!! > i) {
                    visited.remove(stack.pop())
                }

                stack.push(s[i])
                visited.add(s[i])
            }
        }

        val result = CharArray(stack.size)
        for (i in result.indices.reversed()) {
            result[i] = stack.pop()
        }

        return String(result)
    }

    val s = readln()
    println(removeDuplicateLetters(s))
}
