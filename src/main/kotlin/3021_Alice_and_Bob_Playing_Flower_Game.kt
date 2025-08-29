fun main() {
    fun flowerGame(n: Int, m: Int): Long =
        (n / 2 + n % 2).toLong() * (m / 2).toLong() + (m / 2 + m % 2).toLong() * (n / 2).toLong()

    val n = readln().toInt()
    val m = readln().toInt()
    println(flowerGame(n, m))
}