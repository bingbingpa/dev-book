package ch03

tailrec fun binIndexOf(
    x: Int,
    array: IntArray,
    from: Int = 0,
    to: Int = array.size
): Int {
    if (from == to) return -1
    val midIndex = (from + to - 1) / 2
    val mid = array[midIndex]
    return when {
        mid < x -> binIndexOf(x, array, midIndex + 1, to)
        mid > x -> binIndexOf(x, array, from, midIndex)
        else -> midIndex
    }
}

tailrec fun sum(array: IntArray, from: Int = 0, to: Int = array.size): Int {
    return if (from > to) return array[from] + sum(array, from + 1, to) else 0
}


fun main() {
    println(binIndexOf(3, intArrayOf(1, 2, 3, 4, 5, 6, 7, 10, 20, 30)))
}