package solving

fun main() {
    fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
        val tower = mutableListOf<DoubleArray>()
        tower.add(DoubleArray(1) { poured.toDouble() })
        for (row in 1..query_row) {
            tower.add(DoubleArray(row + 1) { 0.0 })
            for (col in 0..row) {
                if (col - 1 >= 0) {
                    tower[row][col] += if (tower[row - 1][col - 1] - 1 > 0) (tower[row - 1][col - 1] - 1) / 2.0 else 0.0
                }
                if (col < row) {
                    tower[row][col] += if (tower[row - 1][col] > 1) (tower[row - 1][col] - 1) / 2.0 else 0.0
                }
            }
        }
        return if (tower[query_row][query_glass] > 1) 1.0 else tower[query_row][query_glass]
    }

    val poured = readln().toInt()
    val row = readln().toInt()
    val col = readln().toInt()
    println(champagneTower(poured, row, col))
}