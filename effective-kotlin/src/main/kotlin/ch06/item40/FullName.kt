package ch06.item40

data class FullName(val name: String, val surname: String)

fun main() {
    val name1 = FullName("Marcin", "Moskala")
    val name2 = FullName("Marcin", "Moskala")
    val name3 = FullName("Maja", "Moskala")

    println(name1 == name1) // true
    println(name1 == name2) // true
    println(name1 == name3) // false

    println(name1 === name1) // true
    println(name1 === name2) // false
    println(name1 === name3) // false
}