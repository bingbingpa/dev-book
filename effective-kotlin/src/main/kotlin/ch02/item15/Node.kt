package ch02.item15

class Node(private val name: String) {

    fun makeChild(childName: String) =
        create("$name.$childName")
            .apply {
                println("Created ${this?.name} in ${this@Node.name}")
            }

    private fun create(name: String): Node? = Node(name)
}

fun main() {
    val node = Node("parent")
    node.makeChild("child")
}