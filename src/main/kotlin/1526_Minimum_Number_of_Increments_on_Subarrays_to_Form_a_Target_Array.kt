fun main() {
    fun minNumberOperations(target: IntArray): Int {
        val n = target.size
        var result = target[0]
        for (i in 1 ..< n) result += maxOf(target[i] - target[i - 1], 0)
        return result
    }

    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(minNumberOperations(s))
}
