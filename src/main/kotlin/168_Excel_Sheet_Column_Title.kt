fun main() {
    val s = readln().toInt()
    println(convertToTitle(s))
}

fun convertToTitle(columnNumber: Int): String {
    var colNum = columnNumber
    var result = ""
    while (colNum > 0) {
        val tmp = (colNum - 1) % 26 + 1
        result = (tmp + 64).toChar() + result
        colNum = (colNum - 1) / 26
    }
    return result
}