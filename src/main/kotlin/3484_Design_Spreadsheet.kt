class Spreadsheet(rows: Int) {
    val data = Array(26) { IntArray(rows) }

    fun setCell(cell: String, value: Int) {
        val i = resolveAddress(cell)
        data[i[0]][i[1]] = value
    }

    fun resetCell(cell: String) {
        val i = resolveAddress(cell)
        data[i[0]][i[1]] = 0
    }

    fun getValue(formula: String): Int {
        val parts = formula.substring(1).split('+')
        var result = 0
        for (part in parts) {
            if (part[0] in 'A'..'Z') {
                val ref = resolveAddress(part)
                result += data[ref[0]][ref[1]]
            } else {
                result += part.toInt()
            }
        }
        return result
    }

    private fun resolveAddress(cell: String): IntArray {
        val i = cell[0] - 'A'
        val j = cell.substring(1).toInt() - 1
        return intArrayOf(i, j)
    }
}