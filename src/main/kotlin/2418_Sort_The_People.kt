fun main() {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
        val people = mutableListOf<Pair<Int, String>>()
        for (i in names.indices) {
            people.add(heights[i] to names[i])
        }
        people.sortByDescending { it.first }
        return people.map { it.second }.toTypedArray()
    }

    val names = readln()
        .replace("[", "")
        .replace("]", "")
        .split(",")
        .map { it.replace("\"", "") }
        .toTypedArray()

    val heights = readln()
        .replace("[", "")
        .replace("]", "")
        .split(",")
        .map { it.toInt() }
        .toIntArray()

    println(sortPeople(names, heights).joinToString())
}
