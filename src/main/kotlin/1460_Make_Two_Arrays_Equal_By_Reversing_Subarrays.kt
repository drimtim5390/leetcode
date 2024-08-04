fun main() {
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        val count = IntArray(1001)
        for (num in target) {
            count[num]++
        }
        for (num in arr) {
            if (count[num] == 0) return false
            count[num]--
        }
        return true
    }

    val target = readln().replace("]", "").replace("[", "").split(",").map { it.toInt() }.toIntArray()
    val arr = readln().replace("]", "").replace("[", "").split(",").map { it.toInt() }.toIntArray()
    println(canBeEqual(target, arr))
}