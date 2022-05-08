package ch11

infix fun <T> ((T) -> Boolean).and(other: (T) -> Boolean): (T) -> Boolean {
    return { this(it) && other(it) }
}

infix fun <T> ((T) -> Boolean).or(other: (T) -> Boolean): (T) -> Boolean {
    return { this(it) || other(it) }
}

operator fun <T> ((T) -> Boolean).not(): (T) -> Boolean = { !this(it) }

fun String.isUpperCase() = all { it.isUpperCase() }

fun isShort(s: String) = s.length <= 4

fun main() {
    val data = listOf("abc", "abcde", "ABCDE", "aBcD", "ab")

    println(data.count(::isShort and String::isUpperCase))
    println(data.count(::isShort or String::isUpperCase))
    println(data.count(!::isShort or String::isUpperCase))
    println(data.count(!::isShort and String::isUpperCase))
}