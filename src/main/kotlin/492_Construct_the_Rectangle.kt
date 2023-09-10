import kotlin.math.sqrt

fun main() {
    val s = readln().toInt()
    println(constructRectangle(s).joinToString())
}

private fun constructRectangle(area: Int): IntArray {
    var result = area
    for (i in sqrt(area.toDouble()).toInt() downTo 2) {
        if (area % i == 0) {
            result = area / i
            break
        }
    }
    return intArrayOf(result, area / result)
}
