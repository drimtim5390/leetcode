fun main() {
    fun isNoZero(num: Int): Boolean {
        var res = true
        var x = num
        while (x >= 10) {
            if (x % 10 == 0) {
                res = false
                break
            }
            x /= 10
        }
        return res
    }

    fun getNoZeroIntegers(n: Int): IntArray {
        for (i in 1..n / 2) {
            if (isNoZero(i) && isNoZero(n - i)) {
                return intArrayOf(i, n - i)
            }
        }
        return IntArray(0)
    }

    val s = readln().toInt()
    println(getNoZeroIntegers(s))
}
