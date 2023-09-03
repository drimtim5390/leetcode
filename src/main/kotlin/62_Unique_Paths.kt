fun main() {
    val m = readln().toInt()
    val n = readln().toInt()
    println(uniquePaths(m, n))
}

fun uniquePaths(m: Int, n: Int): Int {
    val s = IntArray(n + 1)
    s[1] = 1
    for (i in 0 until m)
        for (j in 1..n)
            s[j] += s[j - 1]
    return s[n]
}
