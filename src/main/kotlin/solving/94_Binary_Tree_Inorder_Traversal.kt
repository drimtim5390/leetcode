package solving

fun main() {
    val s = readln()
    println(inorderTraversal(null))
}

private fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    fun traverseTree(node: TreeNode?) {
        if (node == null) return
        traverseTree(node.left)
        result.add(node.`val`)
        traverseTree(node.right)

    }

    traverseTree(root)
    return result
}

private class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}