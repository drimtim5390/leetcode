import java.util.TreeMap

fun main() {
    val s = readln().split(" ").map { it.toInt() }
    println(minLengthAfterRemovals(s))
}

private fun minLengthAfterRemovals(nums: List<Int>): Int {
    if (nums.size == 1) return 1
    var result = 0
    val count = TreeMap<Int, Int>()
    for (num in nums) {
        count[num] = if (count.containsKey(num)) (count[num]!! + 1) else 1
    }
    val counts = count.values.toList().toMutableList()
    println(counts)
    var first = 0
    var second = 1
    while (second < counts.size) {
        val firstc = counts[first]
        val secondc = counts[second]
        if (firstc > secondc) {
            counts[first] = firstc - secondc
            counts[second] = 0
            result += 2 * secondc
            second++
        }
        if (firstc == secondc) {
            counts[first] = 0
            counts[second] = 0
            result += 2 * firstc
            first += 2
            second += 2
        }
        if (firstc < secondc) {
            counts[second] = secondc - firstc
            counts[first] = 0
            second++
            first = second - 1
            result += 2 * firstc
        }
    }
    return nums.size - result
}

