import java.lang.StringBuilder

fun main() {
    fun lengthAfterTransformations(s: String, t: Int): Int {
        val mod = 1000000007
        var cnt = IntArray(26)

        for (c in s) {
            cnt[c - 'a']++
        }

        for (round in 1..t) {
            val nxt = IntArray(26)
            nxt[0] = cnt[25]
            nxt[1] = (cnt[25] + cnt[0]) % mod
            for (i in 2..25) {
                nxt[i] = cnt[i - 1]
            }
            cnt = nxt
        }

        var ans = 0
        for (i in 0..25) {
            ans = (ans + cnt[i]) % mod
        }
        return ans
    }

    val s = readln()
    val t = readln().toInt()
    println(lengthAfterTransformations(s, t))
}
