package ch05.item35

fun plus(a: Int, b: Int) = a + b

fun Int.myPlus(other: Int) = this + other

fun main() {
    val plus1: (Int, Int) -> Int = { a, b -> a + b }
    val plus2: (Int, Int) -> Int = fun(a, b) = a + b
    val plus3: (Int, Int) -> Int = ::plus
    val plus4 = { a: Int, b: Int -> a + b }
    val plus5 = fun(a: Int, b: Int) = a + b
    val myPlus = fun Int.(other: Int) = this + other
    val myPlus2: Int.(Int) -> Int = fun Int.(other: Int) = this + other
    val myPlus3: Int.(Int) -> Int = { this + it }
}