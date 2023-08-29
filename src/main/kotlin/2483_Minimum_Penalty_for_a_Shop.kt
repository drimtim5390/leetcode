fun main() {
    val s = readln()
    println(bestClosingTime(s))
}

fun bestClosingTime(customers: String): Int {
    var balance = 0
    var maxBalance = 0
    var maxHour = 0
    var hour = 0
    for (c in customers) {
        hour++
        when (c) {
            'Y' -> {
                balance++
                if (maxBalance < balance) {
                    maxBalance = balance
                    maxHour = hour
                }
            }
            'N' -> balance--
        }
    }
    return maxHour
}

