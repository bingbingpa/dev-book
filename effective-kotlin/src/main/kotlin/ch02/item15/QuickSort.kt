package ch02.item15

fun <T : Comparable<T>> List<T>.quickSort(): List<T> {
    if (size < 2) return this
    val pivot = first()
    val (smaller, bigger) = drop(1)
        .partition { it < pivot }
    return smaller.quickSort() + pivot + bigger.quickSort()
}

fun <T : Comparable<T>> List<T>.quickSort2(): List<T> {
    if(this.size < 2) return this
    val pivot = this.first()
    val (smaller, bigger) = this.drop(1)
        .partition { it < pivot }
    return smaller.quickSort2() + pivot + bigger.quickSort2()
}

fun main() {
    println(listOf(3, 2, 5, 1, 6).quickSort())
    println(listOf(3, 2, 5, 1, 6).quickSort2())
}