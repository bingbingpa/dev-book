package ch02

fun printSorted(vararg items: Int) {
    items.sort()
    println(items.contentToString())
}

fun main() {
    val numbers = intArrayOf(6, 2, 10, 1)
    printSorted(*numbers)
    println(numbers.contentToString())
}