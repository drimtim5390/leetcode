fun main() {
    fun numSubmat(mat: Array<IntArray>): Int {
        val n = mat.size
        val m = mat[0].size
        val heights = IntArray(n)
        var ans = 0

        val stackH = IntArray(n)
        val stackC = IntArray(n)

        for (i in 0 until n) {
            for (j in 0 until m) {
                heights[j] = if (mat[i][j] == 1) heights[j] + 1 else 0
            }

            var stackSize = 0
            var rowSum = 0

            for (j in 0 until n) {
                val h = heights[j]
                var cnt = 1

                while (stackSize > 0 && stackH[stackSize - 1] >= h) {
                    stackSize--
                    val topH = stackH[stackSize]
                    val topC = stackC[stackSize]
                    cnt += topC
                    rowSum -= topC * (topH - h)
                }

                rowSum += h
                stackH[stackSize] = h
                stackC[stackSize] = cnt
                stackSize++
                ans += rowSum
            }
        }

        return ans
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
    println(numSubmat(matrix.toTypedArray()))
}
