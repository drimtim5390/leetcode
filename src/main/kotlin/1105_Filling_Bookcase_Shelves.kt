fun main() {
    fun minHeightShelves(books: Array<IntArray>, shelfWidth: Int): Int {
        val dp = IntArray(books.size + 1)
        dp[1] = books[0][1]
        for (i in 2..books.size) {
            var remainingShelfWidth = shelfWidth - books[i - 1][0]
            var maxHeight = books[i - 1][1]
            dp[i] = dp[i - 1] + maxHeight
            var j = i - 1
            while (j > 0 && remainingShelfWidth - books[j - 1][0] >= 0) {
                maxHeight = maxOf(maxHeight, books[j - 1][1])
                remainingShelfWidth -= books[j - 1][0]
                dp[i] = minOf(dp[i], maxHeight + dp[j - 1])
                j--
            }
        }
        return dp[books.size]
    }

    val s = readln().replace("[", "").replace("]", "").split(",").map { it.toInt() }
    val tmp = IntArray(2)
    val books = mutableListOf<IntArray>()
    for (i in s.indices) {
        if (i % 2 == 0) {
            tmp[0] = s[i]
        } else {
            tmp[1] = s[i]
            books.add(tmp.clone())
        }
    }
    val shelfWidth = readln().toInt()
    println(minHeightShelves(books.toTypedArray(), shelfWidth))
}
