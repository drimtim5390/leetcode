fun main() {
    val num1 = readln().split(" ").map { it.toInt() }
    val num2 = readln().split(" ").map { it.toInt() }

    val head1 = ListNode(0)
    var node = head1
    num1.forEachIndexed { index, it ->
        node.`val` = it
        if (num1.lastIndex == index) {
            return@forEachIndexed
        }
        node.next = ListNode(0)
        node = node.next!!
    }

    val head2 = ListNode(0)
    node = head2
    num2.forEachIndexed { index, it ->
        node.`val` = it
        if (num2.lastIndex == index) {
            return@forEachIndexed
        }
        node.next = ListNode(0)
        node = node.next!!
    }

    println(addTwoNumbers(head1, head2))
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val result = ListNode(0)
    var next = result
    var prev = ListNode(0)
    var tmp = 0
    var ll1 = l1
    var ll2 = l2
    while (ll1 != null || ll2 != null || tmp != 0) {
        var sum = (ll1?.`val` ?: 0) + (ll2?.`val` ?: 0) + tmp
        tmp = sum / 10
        sum %= 10
        next.`val` = sum
        next.next = ListNode(0)
        prev = next
        next = next.next!!
        ll1 = ll1?.next
        ll2 = ll2?.next
    }
    if (next.`val` == 0) {
        prev.next = null
    }
    return result
}