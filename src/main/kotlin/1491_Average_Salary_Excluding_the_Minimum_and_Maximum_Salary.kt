fun main() {
    val s = readln()
        .replace("[", "")
        .replace("]", "")
        .split(",")
        .map { it.toInt() }
        .toIntArray()
    println(average(s))
}

fun average(salary: IntArray): Double {
    var min = salary[0]
    var max = salary[0]
    var sum = 0

    salary.forEach {
        min = min.coerceAtMost(it)
        max = max.coerceAtLeast(it)
        sum += it
    }

    return (sum - min - max) * 1.0 / (salary.size - 2)
}

