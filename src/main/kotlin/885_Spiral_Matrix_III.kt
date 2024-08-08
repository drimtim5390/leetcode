fun main() {
    fun spiralMatrixIII(rows: Int, cols: Int, rStart: Int, cStart: Int): Array<IntArray> {
        val result = mutableListOf<Pair<Int, Int>>()
        val visited = mutableSetOf<Pair<Int, Int>>()
        var dir = 1
        var x = rStart
        var y = cStart
        while (result.size < rows * cols) {
            visited.add(x to y)
            if (x in 0..<rows && y in 0..<cols) result.add(x to y)
            when (dir) {
                1 -> {
                    if (!visited.contains(x to y + 1)) {
                        y++
                        dir = 2
                    } else {
                        x--
                    }
                }
                2 -> {
                    if (!visited.contains(x + 1 to y)) {
                        x++
                        dir = 3
                    } else {
                        y++
                    }
                }
                3 -> {
                    if (!visited.contains(x to y - 1)) {
                        y--
                        dir = 4
                    } else {
                        x++
                    }
                }
                4 -> {
                    if (!visited.contains(x - 1 to y)) {
                        x--
                        dir = 1
                    } else {
                        y--
                    }
                }
            }
        }
        return result.map { intArrayOf(it.first, it.second) }.toTypedArray()
    }

    val rows = readln().toInt()
    val cols = readln().toInt()
    val rStart = readln().toInt()
    val cStart = readln().toInt()
    println(spiralMatrixIII(rows, cols, rStart, cStart).joinToString("\n") { it.joinToString("\t") })
}
