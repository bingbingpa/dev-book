package ch11

fun main() {
    val myValue by lazy {
        println("Initializing myValue")
        123
    }

    println(myValue)

    val myValue2 by lazy(LazyThreadSafetyMode.PUBLICATION) {
        println("Initializing myValue")
        123
    }

    println(myValue2)

    val x by lazy(LazyThreadSafetyMode.NONE) { 1 + 2 }
    println(x)
}