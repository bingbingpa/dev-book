package ch04

fun main() {
    var x = 1
    val o = object {
        val a = x++
    }

    println("o.a = ${o.a}")
    println("x = $x")
}