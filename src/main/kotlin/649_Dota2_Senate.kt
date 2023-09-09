import java.util.*

fun main() {
    val s = readln()
    println(predictPartyVictory(s))
}

fun predictPartyVictory(senate: String): String {
    val radiant = LinkedList<Int>()
    val dire = LinkedList<Int>()

    for (i in senate.indices) {
        (if (senate[i] == 'R') radiant else dire).addLast(i)
    }

    while (!dire.isEmpty() && !radiant.isEmpty()) {
        val voter = if (dire.first < radiant.first) dire else radiant
        voter.addLast(maxOf(dire.last, radiant.last) + 1)
        dire.removeFirst()
        radiant.removeFirst()
    }

    return if (radiant.isEmpty()) "Dire" else "Radiant"
}
