fun main() {
    val a = readln()
    val b = readln()
    println(addBinary(a, b))
}

fun addBinary(a: String, b: String): String {
    var rem = 0
    var result = ""
    for (i in 1..a.length.coerceAtLeast(b.length)) {
        val first = if (0 <= a.length - i && a.length - i < a.length) a[a.length - i].toString().toInt() else 0
        val second = if (0 <= b.length - i && b.length - i < b.length) b[b.length - i].toString().toInt() else 0
        val sum = first + second + rem
        rem = sum / 2
        result = (sum % 2).toString() + result
    }
    if (rem > 0) {
        result = rem.toString() + result
    }
    return result
}

