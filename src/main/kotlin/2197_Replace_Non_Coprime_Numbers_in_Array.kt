import java.util.LinkedList

fun main() {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    fun replaceNonCoprimes(nums: IntArray): List<Int> {
        val result = LinkedList(nums.toList())
        val it = result.listIterator()
        while (it.hasNext()) {
            val curr = it.next()

            if (it.hasNext()) {
                val next = it.next()

                val gcd = gcd(next, curr)

                if (gcd != 1) {
                    val lcd = 1L * curr * next / gcd
                    it.remove()
                    it.previous()
                    it.set(lcd.toInt())
                }
                if (it.hasPrevious()) {
                    it.previous()
                }
            }
        }
        return result
    }

    val s = readln()
    val array = s
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(replaceNonCoprimes(array))
}
