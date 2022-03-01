package ch06.item36

class CounterSetDelegation<T>(
    private val innerSet: MutableSet<T> = mutableSetOf()
) : MutableSet<T> by innerSet {

    var elementsAdded: Int = 0
        private set

    override fun add(element: T): Boolean {
        elementsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        elementsAdded += elements.size
        return innerSet.addAll(elements)
    }
}

fun main() {
    val counterList = CounterSetDelegation<String>()
    counterList.addAll(listOf("A", "B", "C"))
    println(counterList.elementsAdded)
}