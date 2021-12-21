package ch02

import ch02.Color.*

fun getMnemonic(color: Color) =
    when (color) {
        RED -> "Richard"
        ORANGE -> "Of"
        YELLOW -> "York"
        GREEN -> "Gave"
        BLUE -> "Battle"
        INDIGO -> "In"
        VIOLET -> "Vain"
    }

fun main() {
    println(getMnemonic(BLUE))
}