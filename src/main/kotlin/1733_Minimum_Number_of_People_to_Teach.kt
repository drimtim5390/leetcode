fun main() {
    fun minimumTeachings(n: Int, languages: Array<IntArray>, friendships: Array<IntArray>): Int {
        val m = languages.size
        val blocks = (n + 63) / 64

        val masks = Array(m + 1) { LongArray(blocks) }
        for (i in 1..m) {
            for (lang in languages[i - 1]) {
                val idx = (lang - 1) / 64
                val bit = (lang - 1) % 64
                masks[i][idx] = masks[i][idx] or (1L shl bit)
            }
        }

        val candidates = mutableSetOf<Int>()
        for (f in friendships) {
            val u = f[0]
            val v = f[1]
            var canTalk = false
            for (b in 0 until blocks) {
                if (masks[u][b] and masks[v][b] != 0L) {
                    canTalk = true
                    break
                }
            }
            if (!canTalk) {
                candidates.add(u)
                candidates.add(v)
            }
        }
        if (candidates.isEmpty()) return 0

        val count = IntArray(n + 1)
        for (i in candidates) {
            for (lang in languages[i - 1]) {
                count[lang]++
            }
        }

        val maxOverlap = count.maxOrNull() ?: 0
        return candidates.size - maxOverlap
    }

    val n = readln().toInt()
    val languages = mutableListOf<IntArray>()
    val friendships = mutableListOf<IntArray>()

    var s = readln()
    for (x in s.split("],[")) {
        val array = x
            .replace("[", "")
            .replace("]", "")
            .replace(",", " ")
            .split(" ").map { it.toInt() }.toIntArray()
        languages.add(array)
    }

    s = readln()
    for (x in s.split("],[")) {
        val array = x
            .replace("[", "")
            .replace("]", "")
            .replace(",", " ")
            .split(" ").map { it.toInt() }.toIntArray()
        friendships.add(array)
    }

    println(minimumTeachings(n, languages.toTypedArray(), friendships.toTypedArray()))
}
