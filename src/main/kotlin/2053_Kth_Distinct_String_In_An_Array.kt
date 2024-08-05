fun main() {
    fun kthDistinct(arr: Array<String>, k: Int): String {
        val map = linkedMapOf<String, Int>()
        for (str in arr) map[str] = map.getOrDefault(str, 0) + 1
        var i = 1
        for (entry in map.filter { it.value == 1 }) {
            if (i == k) return entry.key
            i++
        }
        return ""
    }

    val arr = readln().replace("[", "").replace("]", "").replace("\"", "").split(",").toTypedArray()
    val k = readln().toInt()
    println(kthDistinct(arr, k))
}
