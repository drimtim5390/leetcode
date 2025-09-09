fun main() {
    fun peopleAwareOfSecret(n: Int, delay: Int, forget: Int): Int {
        val mod = 1_000_000_007
        val dp = LongArray(n + 1)
        dp[1] = 1
        var shareCount = 0L
        for (day in 2..n) {
            if (day - delay >= 1) {
                shareCount = (shareCount + dp[day - delay]) % mod
            }
            if (day - forget >= 1) {
                shareCount = (shareCount - dp[day - forget] + mod) % mod
            }
            dp[day] = shareCount
        }
        var result = 0L
        for (i in n - forget + 1..n) {
            result = (result + dp[i]) % mod
        }
        return result.toInt()
    }

    val n = readln().toInt()
    val delay = readln().toInt()
    val forget = readln().toInt()
    println(peopleAwareOfSecret(n, delay, forget))
}
