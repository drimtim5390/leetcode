fun main() {
    fun compareVersion(version1: String, version2: String): Int {
        var i = 0
        var j = 0
        while (i < version1.length || j < version2.length) {
            var num1 = 0
            var num2 = 0
            while (i < version1.length && version1[i] != '.') num1 = num1 * 10 + (version1[i++] - '0')
            while (j < version2.length && version2[j] != '.') num2 = num2 * 10 + (version2[j++] - '0')
            if (num1 < num2) return -1
            if (num1 > num2) return 1
            i++
            j++
        }
        return 0
    }

    val version1 = readln()
    val version2 = readln()
    println(compareVersion(version1, version2))
}
