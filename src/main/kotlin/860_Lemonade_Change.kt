fun main() {
    fun lemonadeChange(bills: IntArray): Boolean {
        var b5 = 0
        var b10 = 0
        var b20 = 0
        for (bill in bills) {
            when (bill) {
                5 -> {
                    b5++
                }

                10 -> {
                    if (b5 > 0) {
                        b5--
                    } else {
                        return false
                    }
                    b10++
                }

                20 -> {
                    if (b10 > 0 && b5 > 0) {
                        b10--
                        b5--
                    } else if (b5 > 2) {
                        b5 -= 3
                    } else {
                        return false
                    }
                    b20++
                }
            }
        }
        return true
    }

    val bills = readln().replace("[", "").replace("]", "").split(",").map { it.toInt() }.toIntArray()
    println(lemonadeChange(bills))
}
