class BinaryTree {
    data class Node(var value: Int, var left: Node? = null, var right: Node? = null)

    private var root: Node? = null

    fun insert(value: Int) {
        root = insertNode(root, value)
    }

    private fun insertNode(node: Node?, value: Int): Node {
        node ?: return Node(value)
        when {
            value < node.value -> node.left = insertNode(node.left, value)
            value > node.value -> node.right = insertNode(node.right, value)
        }
        return node
    }

    fun remove(value: Int) {
        root = removeNode(root, value)
    }

    private fun removeNode(node: Node?, value: Int): Node? {
        node ?: return null
        when {
            value < node.value -> node.left = removeNode(node.left, value)
            value > node.value -> node.right = removeNode(node.right, value)
            else -> {
                if (node.left == null && node.right == null) {
                    return null
                }
                if (node.left == null) {
                    return node.right
                }
                if (node.right == null) {
                    return node.left
                }
                val temp = findMin(node.right!!)
                node.value = temp.value
                node.right = removeNode(node.right, temp.value)
            }
        }
        return node
    }

    fun search(value: Int): Boolean {
        return searchNode(root, value) != null
    }

    private fun searchNode(node: Node?, value: Int): Node? {
        node ?: return null
        return when {
            value == node.value -> node
            value < node.value -> searchNode(node.left, value)
            else -> searchNode(node.right, value)
        }
    }

    fun traverse() {
        traverseInOrder(root)
    }

    private fun traverseInOrder(node: Node?) {
        node ?: return
        traverseInOrder(node.left)
        println(node.value)
        traverseInOrder(node.right)
    }

    private fun findMin(node: Node): Node {
        var current = node
        while (current.left != null) {
            current = current.left!!
        }
        return current
    }
}
