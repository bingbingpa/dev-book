package ch07

fun main() {
    println(setOf("abc", "def", "ghi").flatMap { it.asIterable() }) // [a, b, c, d, e, f, g, h, i]
    println(listOf(1, 2, 3, 4).flatMap { listOf(it) }) // [1, 2, 3, 4]
    println(Array(3) { it + 1 }.flatMap { 1..it }) // [1, 1, 2, 1, 2, 3]

    println(
        listOf(listOf(1, 2), setOf(3, 4), listOf(5)).flatten()
    ) // [1, 2, 3, 4, 5]

    println(Array(3) { arrayOf("a", "b") }.flatten()) // [a, b, a, b, a, b]

    println(
        sequence {
            yield(sequenceOf(1, 2))
            yield(sequenceOf(3, 4))
        }.flatten().toList()
    ) // [1, 2, 3, 4]

    println(
        listOf("red", "green", "blue").associateWith { it.length }
    ) // {red=3, green=5, blue=4}

    println(
        generateSequence(1) { if (it > 50) null else it * 3 }
            .associateWith { it.toString(3) }
    ) // {1=1, 3=10, 9=100, 27=1000, 81=10000}

    println(listOf("red", "green", "blue").associateBy { it.length }) // {3=red, 5=green, 4=blue}

    println(intArrayOf(10, 15, 20, 25, 30, 35).associateBy { it / 10 }) // {1=15, 2=25, 3=35}

    println(
        generateSequence(1) { if (it > 50) null else it * 3 }
            .associateBy { it.toString(3) }
    ) // {1=1, 10=3, 100=9, 1000=27, 10000=81}

    println(
        listOf("red", "green", "blue")
            .associate { it.uppercase() to it.length }
    ) // {RED=3, GREEN=5, BLUE=4}

    println(
        intArrayOf(10, 15, 20, 25, 30, 35).associate { it to it / 10 }
    ) // {10=1, 15=1, 20=2, 25=2, 30=3, 35=3}

    println(
        generateSequence(1) { if (it > 50) null else it * 3 }
            .associate {
                val s = it.toString(3)
                "3^${s.length - 1}" to s
            }
    ) // {3^0=1, 3^1=10, 3^2=100, 3^3=1000, 3^4=10000}
}