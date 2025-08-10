fun main() {
    fun reorderedPowerOf2(n: Int): Boolean {
        val sorted = n.toString().toCharArray().sorted().joinToString("")
        var power = 1
        if (n == 1) return true
        while (power.toString().length <= sorted.length) {
            power *= 2
            if (power.toString().toCharArray().sorted().joinToString("") == sorted) {
                return true
            }
        }
        return false
    }

    val s = readln().toInt()

    println(reorderedPowerOf2(s))
}
