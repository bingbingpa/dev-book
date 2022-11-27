package ch3

fun main() {
    val a = "hello world!"
    val b = "hello world!"
    val c = Hello("abc")
    val d = Hello("abc")

    println(a == b) // true
    println(a === b) // true

    println(c == d) // true
    println(c === d) // false
}

data class Hello(val str: String)
