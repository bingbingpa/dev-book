package ch05

fun interface StringConsumer {
    fun accept(s: String)
}

fun main() {
    val consume = StringConsumer { s -> println(s)}
    consume.accept("Hello")
}