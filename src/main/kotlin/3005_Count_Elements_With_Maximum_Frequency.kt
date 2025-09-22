fun main() {
    fun maxFrequencyElements(nums: IntArray): Int {
        var max = 0
        val count = IntArray(101)
        nums.forEach {
            count[it]++
            if (max < count[it]) max = count[it]
        }

        var result = 0
        count.forEach {
            if (it == max) result += it
        }

        return result
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(maxFrequencyElements(s))
}
