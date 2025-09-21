
class Router(private val memoryLimit: Int) {
    data class Packet(val source: Int, val destination: Int, val timestamp: Int)

    private val queue = ArrayDeque<Packet>()
    private val seen = mutableSetOf<Packet>()
    private val destMap = mutableMapOf<Int, MutableList<Int>>()

    fun addPacket(source: Int, destination: Int, timestamp: Int): Boolean {
        val packet = Packet(source, destination, timestamp)
        if (!seen.add(packet)) return false
        if (queue.size == memoryLimit) forwardPacket()
        queue.addLast(packet)
        destMap.getOrPut(destination) { mutableListOf() }.add(timestamp)
        return true
    }

    fun forwardPacket(): IntArray {
        val oldest = queue.removeFirstOrNull() ?: return intArrayOf()
        seen.remove(oldest)
        destMap[oldest.destination]?.let {
            it.removeAt(0)
            if (it.isEmpty()) destMap.remove(oldest.destination)
        }
        return intArrayOf(oldest.source, oldest.destination, oldest.timestamp)
    }

    fun getCount(destination: Int, startTime: Int, endTime: Int): Int {
        val times = destMap[destination] ?: return 0

        var left = 0
        var right = times.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            if (times[mid] >= startTime) right = mid - 1 else left = mid + 1
        }
        val l = left

        left = 0
        right = times.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            if (times[mid] <= endTime) left = mid + 1 else right = mid - 1
        }
        val r = right

        return if (r >= l) r - l + 1 else 0
    }
}
