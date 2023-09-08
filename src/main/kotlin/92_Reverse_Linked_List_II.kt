fun main() {
    val head = ListNode(1)
    var next = head
    for (i in 2..5) {
        next.next = ListNode(i)
        next = next.next!!
    }
    println(reverseBetween(head, 2, 3))
}

fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
    var result = head
    var edge: ListNode? = null
    var start: ListNode? = null
    var node = head
    var prev: ListNode? = null
    var index = 1
    while (node != null) {
        when (index) {
            left -> {
                edge = prev
                start = node
                prev = node
                node = node.next
            }
            in (left + 1)..<right -> {
                val prevPrev = prev
                prev = node
                node = node.next
                prev.next = prevPrev
            }
            right -> {
                val prevPrev = prev
                prev = node
                node = node.next
                prev.next = prevPrev
                edge?.next = prev
                if (left == 1) {
                    result = prev
                }
                start?.next = node
            }
            else -> {
                prev = node
                node = node.next
            }
        }
        index++
    }
    return result
}

