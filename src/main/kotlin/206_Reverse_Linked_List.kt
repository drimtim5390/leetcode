fun main() {
    val head = ListNode(1)
    var next = head
    for (i in 2..5) {
        next.next = ListNode(i)
        next = next.next!!
    }
    println(reverseList(head))
}

fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var current = head
    var next: ListNode?
    while (current != null) {
        next = current.next
        current.next = prev
        prev = current
        current = next
    }
    return prev
}

