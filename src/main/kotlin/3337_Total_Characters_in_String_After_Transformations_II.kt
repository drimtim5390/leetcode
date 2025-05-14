fun main() {
    val mod = 1e9.toLong() + 7

    fun lengthAfterTransformations(s: String, t: Int, nums: List<Int>): Int {
        val mp: MutableMap<Int, MutableMap<Int, LongArray>> = mutableMapOf()

        for (i in 0 until 26) {
            val v = LongArray(26) { 0 }
            for (j in 1..nums[i]) {
                v[(i + j) % 26]++
            }
            mp[1] = mp.getOrPut(1) { mutableMapOf() }.apply { this[i] = v }
        }

        var m = 2
        while (m <= t) {
            for (i in 0 until 26) {
                val v = LongArray(26) { 0 }
                val pre = mp[m / 2]!![i]!!
                for (j in 0 until 26) {
                    val prex = mp[m / 2]!![j]!!
                    for (k in 0 until 26) {
                        v[k] = (v[k] + (pre[j] % mod * prex[k] % mod)) % mod
                    }
                }
                mp[m] = mp.getOrPut(m) { mutableMapOf() }.apply { this[i] = v }
            }
            m *= 2
        }

        val c = LongArray(26) { 0 }
        for (ch in s) {
            c[ch - 'a']++
        }

        var maxi = 1 shl 30
        var tt = t
        while (tt > 0) {
            if (tt >= maxi) {
                val v = LongArray(26) { 0 }
                for (i in 0 until 26) {
                    val pre = mp[maxi]!![i]!!
                    for (j in 0 until 26) {
                        v[j] = (v[j] + (c[i] % mod * pre[j] % mod)) % mod
                    }
                }
                System.arraycopy(v, 0, c, 0, 26)
                tt -= maxi
            }
            maxi /= 2
        }

        var res = 0L
        for (i in 0 until 26) {
            res = (res + c[i]) % mod
        }

        return res.toInt()
    }

    val s = readln()
    val t = readln().toInt()
    val nums = readln()
        .replace("[", "")
        .replace("]", "")
        .replace(",", " ")
        .split(" ")
        .filter { it.isNotBlank() }
        .map { it.toInt() }

    println(lengthAfterTransformations(s, t, nums))
}
