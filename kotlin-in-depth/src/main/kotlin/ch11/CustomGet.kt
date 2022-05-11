package ch11

class TreeNode<T>(var data: T) {
    private val _children = arrayListOf<TreeNode<T>>()

    operator fun invoke(index: Int) = _children[index]

    operator fun get(index: Int) = _children[index]
}

fun main() {
    val node = TreeNode(3)
    node[1]
    node(1)
}

/**
 * 구현해보기
 * operator fun <T, R, U>MutableMap<T, R>.getValue(...):U{ }
 */