fun main() {
    fun solve(s: String): Any {
        return 1
    }

    val s = readln()
    println(solve(s))

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
