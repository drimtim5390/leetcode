fun main() {
    val n = readln().toInt()
    println(climbStairs(n))
}

fun climbStairs(n: Int): Int {
    var n0 = 1
    var n1 = 1
    for (i in 2..n) {
        val tmp = n1
        n1 += n0
        n0 = tmp
    }
    return n1
}

