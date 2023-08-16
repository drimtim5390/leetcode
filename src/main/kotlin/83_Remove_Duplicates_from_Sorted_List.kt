fun main() {
    val s = readln().split(" ").map { it.toInt() }.toList()
    val head = ListNode(s[0])
    var tmpHead = head
    for (i in 1..s.lastIndex) {
        val node = ListNode(s[i])
        tmpHead.next = node
        tmpHead = node
    }
    println(head)
    println(deleteDuplicates(head))
}

fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }

    var h = head
    while (h?.next != null) {
        if (h.`val` == h.next!!.`val`) {
            h.next = h.next!!.next
        } else {
            h = h.next
        }
    }
    return head
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "$`val` ${next.toString()}"
    }
}