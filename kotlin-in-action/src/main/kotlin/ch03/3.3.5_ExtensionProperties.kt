package ch03

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }

fun main() {
    val stringBuilder = StringBuilder("Kotlin!")
    println(stringBuilder.lastChar)
    stringBuilder.lastChar = '?'
    println(stringBuilder)
}
