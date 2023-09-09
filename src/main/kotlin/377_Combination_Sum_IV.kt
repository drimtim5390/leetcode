fun main() {
    val s = readln().split(" ").map { it.toInt() }.toIntArray()
    val n = readln().toInt()
    println(combinationSum4(s, n))
}

fun combinationSum4(nums: IntArray, target: Int): Int {
    val combinations = IntArray(target + 1) { 0 }
    combinations[0] = 1
    for (i in 1..target) {
        for (num in nums) {
            if (i - num < 0) continue
            combinations[i] += combinations[i - num]
        }
    }
    return combinations[target]
}
