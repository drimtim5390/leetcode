fun main() {
    fun getSneakyNumbers(nums: IntArray): IntArray {
        val doubles = IntArray(2)
        var count = 0
        val exists = BooleanArray(nums.size - 1)
        for (num in nums) {
            if (exists[num]) doubles[count++] = num
            exists[num] = true
        }
        return doubles
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(getSneakyNumbers(s))
}
