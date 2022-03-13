package ch04

fun main() {
    fun midPoint(xRange: IntRange, yRAnge: IntRange) = object {
        val x = (xRange.first + xRange.last) / 2
        val y = (yRAnge.first + yRAnge.last) / 2
    }

    val midPoint = midPoint(1..5, 2..6)
    println("${midPoint.x}, ${midPoint.y}")
}