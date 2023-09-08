fun main() {
    val n = readln().toInt()
    println(generate(n))
}

fun generate(numRows: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    var level = List(1) { 1 }
    result.add(level)
    for (i in 1 until numRows) {
        level = MutableList(i + 1) { 1 }
        val prevLevel = result[i - 1]
        for (j in 1 until i) {
            level[j] = prevLevel[j - 1] + prevLevel[j]
        }
        result.add(level)
    }
    return result
}
