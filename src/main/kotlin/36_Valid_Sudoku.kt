fun main() {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array(9) { BooleanArray(9) }
        val cols = Array(9) { BooleanArray(9) }
        val cubes = Array(9) { BooleanArray(9) }

        for (i in 0..8) {
            for (j in 0..8) {
                if (board[i][j] != '.') {
                    val tmp = board[i][j] - '1'
                    val cubeI = (i / 3) * 3 + j / 3
                    if (rows[i][tmp] || cols[j][tmp] || cubes[cubeI][tmp]) return false
                    rows[i][tmp] = true
                    cols[j][tmp] = true
                    cubes[cubeI][tmp] = true
                }
            }
        }

        return true
    }

    val s = readln()
    val matrix = mutableListOf<CharArray>()
    for (x in s.split("],[")) {
        val array = x
            .replace("[", "")
            .replace("]", "")
            .replace(",", " ")
            .replace("\"", "")
            .split(" ").map { it.trim()[0] }.toCharArray()
        matrix.add(array)
    }
    println(isValidSudoku(matrix.toTypedArray()))
}
