fun main() {
    val s = readln()
    println(romanToInt(s))
}

fun romanToInt(s: String): Int {
    var result = 0
    var prevSum = 0
    var previous = 0
    for (c in s) {
        val intVal = c.getIntVal()
        if (intVal < previous) {
            result += prevSum
            prevSum = intVal
        }
        if (intVal == previous) {
            prevSum += intVal
        }
        if (intVal > previous) {
            prevSum = intVal - prevSum
        }
        previous = intVal
    }
    return result + prevSum
}

fun Char.getIntVal(): Int {
    return when(this) {
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 500
        'M' -> 1000
        else -> 0
    }
}