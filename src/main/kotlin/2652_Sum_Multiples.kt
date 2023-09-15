fun main() {
    val s = readln().toInt()
    println(sumOfMultiples(s))
}

private fun sumOfMultiples(n: Int): Int {
    return (
                    sum(n, 3)
                    + sum(n, 5)
                    + sum(n, 7)
                    - sum(n, 15)
                    - sum(n, 21)
                    - sum(n, 35)
                    + sum(n, 105)
            )
}

private fun sum(end: Int, divisor: Int): Int {
    val count = end / divisor
    val max = divisor * count
    return max * (count + 1) / 2
}

