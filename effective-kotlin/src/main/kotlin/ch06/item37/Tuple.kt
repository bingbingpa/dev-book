package ch06.item37

enum class Color {
    BLUE, YELLOW, RED
}

fun getColor(degrees: Int): Pair<String, Color> = when {
        degrees < 5 -> "cold" to Color.BLUE
        degrees < 23 -> "mild" to Color.YELLOW
        else -> "hot" to Color.RED
    }

fun main() {
    val (description, color) = getColor(20)
    println("description: ${description}, color: $color")

    val numbers = listOf(1,2,3)
    val (odd, even) = numbers.partition { it % 2 == 1 }
    val map = mapOf(1 to "San Francisco", 2 to "Amsterdam")
    map.mapValues { (key, value) -> println("$value!") }
}
