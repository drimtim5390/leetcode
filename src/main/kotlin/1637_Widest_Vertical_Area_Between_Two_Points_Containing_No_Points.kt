fun main() {
    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
        val xs = points.map { it[0] }.toSet().sorted()
        var x1 = Int.MAX_VALUE
        var result = 0
        for (x in xs) {
            result = result.coerceAtLeast(x - x1)
            x1 = x
        }
        return result
    }

    val s = readln()
    val matrix = mutableListOf<IntArray>()
    for (x in s.split("],[")) {
        val array = x
            .replace("[", "")
            .replace("]", "")
            .replace(",", " ")
            .split(" ").map { it.toInt() }.toIntArray()
        matrix.add(array)
    }
    println(maxWidthOfVerticalArea(matrix.toTypedArray()))
}
