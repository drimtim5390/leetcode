package solving

fun main() {
    val head = Node(0)
    head.next = Node(1)
    head.next!!.next = Node(2)
    head.next!!.next?.random = head.next
    head.next!!.random = head
    println(copyRandomList(head))
}

fun copyRandomList(node: Node?): Node? {
    val nodeList = mutableListOf<Node>()
    var nextNode = node
    while (nextNode != null) {
        nodeList.add(nextNode)
        nextNode = nextNode.next
    }

    val copyNodeList = mutableListOf<Node>()
    var head: Node? = null
    var copyNode: Node? = null

    for (i in 0 until nodeList.size) {
        val tmpNode = nodeList[i]
        if (head == null) {
            head = Node(tmpNode.`val`)
            copyNode = head
        } else {
            copyNode?.next = Node(tmpNode.`val`)
            copyNode = copyNode!!.next
        }
        copyNodeList.add(copyNode!!)
    }

    for (i in 0 until copyNodeList.size) {
        val tmpNode = nodeList[i]
        if (tmpNode.random == null) continue
        copyNodeList[i].random = copyNodeList[nodeList.indexOf(tmpNode.random)]
    }

    return head
}

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null

    override fun toString(): String {
        println("$`val` ${next.toString()}")
        return super.toString()
    }
}