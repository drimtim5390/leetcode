fun main() {
    fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
        val nodes = mutableMapOf<Int,TreeNode>()
        val parents = mutableSetOf<Int>()
        val children = mutableSetOf<Int>()
        for (description in descriptions) {
            if (!nodes.containsKey(description[0])) {
                nodes[description[0]] = TreeNode(description[0])
            }
            val node = nodes[description[0]]!!
            if (!nodes.containsKey(description[1])) {
                nodes[description[1]] = TreeNode(description[1])
            }
            val child = nodes[description[1]]!!
            if (description[2] == 1) {
                node.left = child
            } else {
                node.right = child
            }
            if (!children.contains(description[0])) parents.add(description[0])
            if (parents.contains(description[1])) parents.remove(description[1])
            children.add(description[1])
        }
        return nodes[parents.first()]
    }

    val s = readln()
    val matrix = mutableListOf<IntArray>()
    for (x in s.split("],[")) {
        val array = x
            .replace("[", "")
            .replace("]", "")
            .replace(",", " ")
            .split(" ").map { it.toInt() }.toIntArray()
        matrix.add(array)
    }
    println(createBinaryTree(matrix.toTypedArray()))
}

private class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}