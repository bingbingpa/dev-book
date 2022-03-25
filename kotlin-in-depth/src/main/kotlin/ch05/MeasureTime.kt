package ch05

fun measureTime(action: () -> Unit): Long {
    val start = System.nanoTime()

    action()

    return System.nanoTime() - start
}

fun main() {
    measureTime {
        var sum = 0
        for (i in 1..100000000) {
            sum += i
        }
    }.also { println(it) }
}