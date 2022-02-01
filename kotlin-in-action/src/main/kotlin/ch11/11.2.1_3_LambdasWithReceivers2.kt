package ch11.ex2_1_3_LambdasWithReceivers2

val appendExcel : StringBuilder.() -> Unit = { this.append("!") }

fun main() {
    val stringBuilder = StringBuilder("Hi")
    stringBuilder.appendExcel()
    println(stringBuilder)
    println(buildString(appendExcel))
}