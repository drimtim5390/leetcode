fun main() {
    fun imageSmoother(img: Array<IntArray>): Array<IntArray> = img.mapIndexed { i, row ->
        row.mapIndexed { j, col ->
            var sum = col
            var count = 1
            if (i - 1 >= 0 && j - 1 >= 0) {
                sum += img[i - 1][j - 1]
                count++
            }
            if (i - 1 >= 0 && j >= 0) {
                sum += img[i - 1][j]
                count++
            }
            if (i - 1 >= 0 && j + 1 < row.size ) {
                sum += img[i - 1][j + 1]
                count++
            }
            if (j + 1 < row.size) {
                sum += img[i][j + 1]
                count++
            }
            if (i + 1 < img.size && j + 1 < row.size) {
                sum += img[i + 1][j + 1]
                count++
            }
            if (i + 1 < img.size) {
                sum += img[i + 1][j]
                count++
            }
            if (i + 1 < img.size && j - 1 >= 0) {
                sum += img[i + 1][j - 1]
                count++
            }
            if (j - 1 >= 0) {
                sum += img[i][j - 1]
                count++
            }
            sum / count
        }.toIntArray()
    }.toTypedArray()

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
    println(imageSmoother(matrix.toTypedArray()).joinToString { it.joinToString() })
}
