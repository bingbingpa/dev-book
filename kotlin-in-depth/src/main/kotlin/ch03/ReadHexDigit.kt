package ch03

fun readHexDigit() = when(val n = readLine()!!.toInt()) {
    in 0..9 -> '0' + n
    in 10..15 -> 'A' + n - 10
    else -> '?'
}

fun main() {
    println(readHexDigit())
}