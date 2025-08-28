fun main() {
    fun sortMatrix(grid: Array<IntArray>): Array<IntArray> {
        val n = grid.size

        for (i in n - 1 downTo 1) {
            var x = 0
            var y = i
            val elems = IntArray(n - i)
            var index = 0
            while (y < n) {
                elems[index++] = grid[x][y]
                y++
                x++
            }
            elems.sort()
            x = 0
            y = i
            index = 0
            while (y < n) {
                grid[x][y] = elems[index++]
                y++
                x++
            }
        }

        for (i in 0 until n) {
            var x = i
            var y = 0
            val elems = IntArray(n - i)
            var index = 0
            while (x < n) {
                elems[index++] = grid[x][y]
                y++
                x++
            }
            elems.sort()
            x = i
            y = 0
            index = elems.lastIndex
            while (x < n) {
                grid[x][y] = elems[index--]
                y++
                x++
            }
        }

        return grid
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
    println(sortMatrix(matrix.toTypedArray()))
}
