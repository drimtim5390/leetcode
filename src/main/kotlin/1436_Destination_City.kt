fun main() {
    fun destCity(paths: List<List<String>>): String {
        val start = mutableSetOf<String>()

        paths.forEach {
            start.add(it[0])
        }

        for (path in paths) {
            if (!start.contains(path[1])) return path[1]
        }

        return ""
    }

    val s = readln()
    val matrix = mutableListOf<List<String>>()
    for (x in s.split("],[")) {
        val list = x
            .replace("[", "")
            .replace("]", "")
            .replace(",", " ")
            .split(" ").toList()
        matrix.add(list)
    }
    println(destCity(matrix))
}
