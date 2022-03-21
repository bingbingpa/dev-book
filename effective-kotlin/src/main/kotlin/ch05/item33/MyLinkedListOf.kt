package ch05.item33

class MyLinkedList<T>(head: T, vararg tail: MyLinkedList<T>?)

fun <T> myLinkedListOf(vararg elements: T): MyLinkedList<T>? {
    if(elements.isEmpty()) return null
    val head = elements.first()
    val elementsTail = elements.copyOfRange(1, elements.size)
    val tail = myLinkedListOf(*elementsTail)
    return MyLinkedList<T>(head, tail)
}
