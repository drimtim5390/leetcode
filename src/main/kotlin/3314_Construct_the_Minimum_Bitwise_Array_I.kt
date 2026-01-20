fun main() {
    fun minBitwiseArray(nums: List<Int>): IntArray {
        val result = IntArray(1024) { -1 }

        for (i in 1..1000) {
            val index = i or i + 1
            if (result[index] > i || result[index] == -1) result[index] = i
        }

        return nums.map { result[it] }.toIntArray()
    }

    val nums = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }

    println(minBitwiseArray(nums))
}
