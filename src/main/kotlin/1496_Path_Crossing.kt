fun main() {
    fun isPathCrossing(path: String): Boolean {
        var x = 0
        var y = 0
        val points = mutableSetOf("0,0")
        for (direction in path) {
            when (direction) {
                'N' -> y++
                'S' -> y--
                'E' -> x++
                'W' -> x--
            }
            if (points.contains("$x,$y")) {
                return true
            }
            points.add("$x,$y")
        }
        return false
    }

    val s = readln()
    println(isPathCrossing(s))
}
