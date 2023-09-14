import java.util.PriorityQueue

fun main() {
    var s = readln()
    val tickets = mutableListOf<List<String>>()
    while (s.isNotEmpty()) {
        val ticket = s.split(" ")
        tickets.add(ticket)
        s = readln()
    }
    println(findItinerary(tickets))
}

private fun findItinerary(tickets: List<List<String>>): List<String> {
    val fromTo = HashMap<String, PriorityQueue<String>>()

    tickets.forEach {
        fromTo.getOrPut(it[0]) { PriorityQueue() } += it[1]
    }

    val result = mutableListOf<String>()

    fun startTraversing(source: String) {
        while (fromTo[source]?.isNotEmpty() == true) {
            startTraversing(fromTo[source]!!.poll())
        }
        result.add(0, source)
    }

    startTraversing("JFK")

    return result
}
