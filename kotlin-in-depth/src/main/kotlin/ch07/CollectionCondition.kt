package ch07

fun main() {
    println(listOf(1,2,3,4).all { it < 10 }) // true
    println(listOf(1,2,3,4).all { it % 2 == 0 }) // false
    println(
        mapOf(1 to "I", 5 to "V", 10 to "X")
            .all { it.key ==1 || it.key % 5 == 0 }
    ) // true

    println(listOf(10).single()) // 1

    println(listOf(1,2,3,4).none{ it > 5}) // true

    println(listOf(1,2,3,4).any()) // true
    println(listOf(1,2,3,4).any { it < 0 }) // false

}