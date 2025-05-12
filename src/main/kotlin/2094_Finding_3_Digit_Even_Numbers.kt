fun main() {
    fun findEvenNumbers(digits: IntArray): IntArray {
        val total = IntArray(10)
        val used = IntArray(10)
        for (digit in digits) {
            total[digit]++
        }

        val result = mutableListOf<Int>()

        fun dfs(index: Int, current: Int) {
            if (index == 3) {
                result.add(current)
                return
            }
            for ((digit, max) in total.withIndex()) {
                if (max == used[digit]) continue
                if (index == 0 && digit == 0) continue
                if (index == 2 && digit % 2 != 0) continue
                used[digit]++
                dfs(index + 1, current * 10 + digit)
                used[digit]--
            }
        }

        dfs(0, 0)

        return result.toIntArray()
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(findEvenNumbers(s).joinToString())
}
