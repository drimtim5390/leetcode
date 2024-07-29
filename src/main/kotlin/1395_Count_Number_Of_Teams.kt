fun main() {
    fun numTeams(rating: IntArray): Int {
        val n = rating.size
        val leftSmaller = IntArray(n)
        val leftGreater = IntArray(n)
        val rightSmaller = IntArray(n)
        val rightGreater = IntArray(n)

        for (j in 1 until n) {
            for (i in 0 until j) {
                if (rating[i] < rating[j]) leftSmaller[j]++
                if (rating[i] > rating[j]) leftGreater[j]++
            }
        }

        for (j in 0 until n - 1) {
            for (i in j + 1 until n) {
                if (rating[i] < rating[j]) rightSmaller[j]++
                if (rating[i] > rating[j]) rightGreater[j]++
            }
        }

        var count = 0
        for (j in 0 until n) {
            count += leftSmaller[j] * rightGreater[j]
            count += leftGreater[j] * rightSmaller[j]
        }

        return count
    }

    val rating = readln().replace("[", "").replace("]", "").split(",").map { it.toInt() }.toIntArray()
    println(numTeams(rating))
}
