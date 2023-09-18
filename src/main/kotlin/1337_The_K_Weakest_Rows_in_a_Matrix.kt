fun main() {
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
    val k = readln().toInt()
    println(kWeakestRows(matrix.toTypedArray(), k).joinToString())
}

private fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray = mat.map {
        var score = 0
        run loop@{
            it.forEach {
                if (it == 1) score++ else return@loop
            }
        }
        score
    }
        .mapIndexed { index, it -> Pair(index, it) }
        .sortedWith(compareBy({ it.second }, { it.first }))
        .map { it.first }
        .slice(0 until k).toIntArray()

