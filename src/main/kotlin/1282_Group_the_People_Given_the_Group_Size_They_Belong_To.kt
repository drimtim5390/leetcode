fun main() {
    val s = readln().split(" ").map { it.toInt() }.toIntArray()
    println(groupThePeople(s))
}

private fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
    val result = ArrayList<ArrayList<Int>>()
    val groups = HashMap<Int, ArrayList<Int>>()

    for (i in groupSizes.indices) {
        val groupSize = groupSizes[i]

        if (groupSize == 1) {
            result.add(arrayListOf(i))
            continue
        }

        if (!groups.containsKey(groupSize)) groups[groupSize] = arrayListOf()

        groups[groupSize]!!.add(i)

        if (groups[groupSize]?.size == groupSize) {
            result.add(groups[groupSize]!!)
            groups.remove(groupSize)
        }
    }

    return result
}

