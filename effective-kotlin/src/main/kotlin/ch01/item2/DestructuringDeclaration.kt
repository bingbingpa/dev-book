package ch01.item2

import ch01.item2.Color.*

enum class Color {
    BLUE, YELLOW, RED
}

fun badCaseUpdateWeather(degrees: Int) {
    val description: String
    val color: Color
    if (degrees < 5) {
        description = "cold"
        color = BLUE
    } else if (degrees < 23) {
        description = "mild"
        color = YELLOW
    } else {
        description = "hot"
        color = RED
    }
    println("description: ${description}, color: ${color}")
}

fun goodCaseUpdateWeather(degrees: Int) {
    val (description, color) = when {
        degrees < 5 -> "cold" to BLUE
        degrees < 23 -> "mild" to YELLOW
        else -> "hot" to RED
    }

    println("description: ${description}, color: ${color}")
}

fun main() {
    badCaseUpdateWeather(3)
    goodCaseUpdateWeather(3)
}