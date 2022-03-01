package ch06.item36

class CounterSetComposition<T> {
    private val innerSet = HashSet<T>()
    var elementsAdded: Int = 0
        private set

    fun add(element: T) {
        elementsAdded++
        innerSet.add(element)
    }

    fun addAll(elements: Collection<T>) {
        elementsAdded += elements.size
        innerSet.addAll(elements)
    }
}

fun main() {
    val counterList = CounterSetComposition<String>()
    counterList.addAll(listOf("A", "B", "C"))
    println(counterList.elementsAdded)
}