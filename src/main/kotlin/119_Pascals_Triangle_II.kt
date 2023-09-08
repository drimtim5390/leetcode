fun main() {
    val n = readln().toInt()
    println(getRow(n))
}

fun getRow(rowIndex: Int): List<Int> {
    val result = ArrayList<Int>()
    for (i in 0..rowIndex) {
        result.add(1)
        for (j in i-1 downTo 1) {
            result[j] = result[j] + result[j - 1]
        }
    }
    return result
}
