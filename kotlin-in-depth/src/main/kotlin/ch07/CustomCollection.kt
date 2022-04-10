package ch07

class CustomIntList<T>(
    private val innerList: MutableList<T> = mutableListOf()
): MutableList<T> by innerList {

    override fun contains(element: T) = innerList.contains(element)
}

fun main() {
    val customIntList = CustomIntList<Int>()
    customIntList.add(1)
    customIntList.add(2)
    customIntList.add(3)

    println(1 in customIntList) // true
    println(10 in customIntList) // false
}