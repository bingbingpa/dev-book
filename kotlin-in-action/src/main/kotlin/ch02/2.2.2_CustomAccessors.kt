package ch02

class Rectangle(private val height: Int, private val width: Int) {
    val isSquare: Boolean
        get() = height == width
}

fun main() {
    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)
}