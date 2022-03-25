package ch05

inline fun indexOf(numbers: IntArray, condition: (Int) -> Boolean): Int {
    for (i in numbers.indices) {
        if(condition(numbers[i])) return i
    }
    return -1
}

fun main() {
    println(indexOf(intArrayOf(4, 3, 2, 1)) { it < 3})
}