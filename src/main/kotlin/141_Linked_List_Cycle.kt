fun main() {
    val s = readln().split(" ").map { it.toInt() }
    var head: ListNode? = null
    var current: ListNode? = null
    s.forEach {
        if (current == null) {
            current = ListNode(it)
            head = current
            return@forEach
        }
        current!!.next = ListNode(it)
        current = current!!.next
    }
    println(head)
    println(hasCycle(head))
}

fun hasCycle(head: ListNode?): Boolean {
//    Constant space solution
//    var listNode = head
//    if (listNode?.next == null) return false
//    while (listNode?.next != null) {
//        if (listNode == listNode?.next) return true
//        listNode?.next = listNode?.next!!.next
//        listNode = listNode?.next
//    }
//    return false

//    Dispatching runners with different velocity solution

    if (head == null) return false
    var slowRunner = head
    var fastRunner = head.next?.next
    while (fastRunner != null && fastRunner != slowRunner) {
        slowRunner = slowRunner?.next
        fastRunner = fastRunner.next?.next
    }
    return fastRunner != null


//    Visited indicator solution
//
//    var current = head
//    while (current != null) {
//        if (current.`val` == Integer.MIN_VALUE) {
//            return true
//        }
//        current.`val` = Integer.MIN_VALUE
//        current = current.next
//    }
//    return false
}
