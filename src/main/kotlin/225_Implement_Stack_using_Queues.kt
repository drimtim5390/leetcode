import java.util.*

fun main() {
    val x = readln().toInt()
    var obj = MyStack()
    obj.push(x)
    var param_2 = obj.pop()
    var param_3 = obj.top()
    var param_4 = obj.empty()
}

class MyStack() {

    private val queue = LinkedList<Int>()

    fun push(x: Int) {
        queue.add(x)
        for (i in 0 until queue.lastIndex) {
            queue.add(queue.pollLast())
        }
    }

    fun pop(): Int {
        return queue.pollLast()
    }

    fun top(): Int {
        return queue.peekLast()
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }
}