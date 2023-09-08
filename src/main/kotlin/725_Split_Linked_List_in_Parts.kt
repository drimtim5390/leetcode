fun main() {
    println(splitListToParts(null, 1))
}

fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
    val heads = Array<ListNode?>(k) { null }

    val nodes = mutableListOf<ListNode>()

    var size = 0
    var node = head
    while (node != null) {
        size++
        nodes.add(node)
        node = node.next
    }

    var biggerNodesCount = size % k
    val nodesSize = size / k
    var index = 0

    for (i in heads.indices) {
        if (size < k) {
            if (index < size) {
                heads[i] = nodes[index++]
                heads[i]?.next = null
            }
            continue
        }

        heads[i] = nodes[index]
        index += if (biggerNodesCount-- > 0) nodesSize else (nodesSize - 1)
        nodes[index++].next = null
    }

    return heads
}

