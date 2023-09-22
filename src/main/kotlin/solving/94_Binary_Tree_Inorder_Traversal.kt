package solving

import solve

fun main() {
    val s = readln()
    println(solve(s))
}

private fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    fun traverseTree(node: TreeNode) {
        node.left?.let { traverseTree(it) }
        result.add(node.`val`)
        node.right?.let { traverseTree(it) }
    }

    root?.let { traverseTree(it) }
    return result
}

private class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}