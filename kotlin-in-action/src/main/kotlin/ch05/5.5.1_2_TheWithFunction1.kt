package ch05

import java.lang.StringBuilder

fun alphabet() : String {
    return with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet!")
        this.toString()
    }
}

fun main() {
    println(alphabet())
}