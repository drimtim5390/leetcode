package solving

fun main() {
    val s1 = readln()
    val s2 = readln()
    val s3 = readln()
    println(isInterleave(s1, s2, s3))
}

fun isInterleave(s1: String, s2: String, s3: String): Boolean {
    val strings = arrayOf(s1, s2)
    val indexes = intArrayOf(0, 0)
    var i = 0
    for (c in s3) {
        when {
            indexes[i] < strings[i].length && strings[i][indexes[i]] == c -> {
                indexes[i]++
            }
            indexes[1 - i] < strings[1 - i].length && strings[1 - i][indexes[1 - i]] == c -> {
                i = 1 - i
                indexes[i]++
            }
            else -> {
                return false
            }
        }
    }
    return indexes[0] == strings[0].length && indexes[1] == strings[1].length
}

