fun main() {
    val n = readln().toInt()
    println(bulbSwitch(n))
}

fun bulbSwitch(n: Int): Int {
    // My solution
    var inc = 1
    var sum = 0
    var result = 0
    while (sum + inc <= n) {
        result++
        sum += inc
        inc += 2
    }
    return result

    // Very clever solution unlike me
    // return Math.sqrt(n.toDouble()).toInt()
}
