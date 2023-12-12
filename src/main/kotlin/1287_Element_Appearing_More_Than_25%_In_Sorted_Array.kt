fun main() {
    fun findSpecialInteger(arr: IntArray): Int {
        var count = 0
        var int = -1
        arr.forEach {
            if (it == int) count++ else count = 1
            int = it
            if (count > arr.size / 4) return it
        }
        return int
    }

    val s = readln().replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ").map { it.toInt() }.toIntArray()
    println(findSpecialInteger(s))

//    val matrix = mutableListOf<IntArray>()
//    for (x in s.split("],[")) {
//        val array = x
//            .replace("[", "")
//            .replace("]", "")
//            .replace(",", " ")
//            .split(" ").map { it.toInt() }.toIntArray()
//        matrix.add(array)
//    }
//    println(solve(matrix.toTypedArray()))
}
