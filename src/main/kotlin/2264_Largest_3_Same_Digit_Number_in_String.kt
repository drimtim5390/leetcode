fun main() {
    fun largestGoodInteger(num: String): String = arrayOf("999", "888", "777", "666", "555", "444", "333", "222", "111", "000").firstOrNull { it in num } ?: ""

    val s = readln()
    println(largestGoodInteger(s))
}
