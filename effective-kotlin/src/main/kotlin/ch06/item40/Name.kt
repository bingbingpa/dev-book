package ch06.item40

class Name(val name: String)

fun main() {
    val name1 = Name("Marcin")
    val name2 = Name("Marcin")
    val name1Ref = name1

    println(name1 == name1)
    println(name1 == name2)
    println(name1 == name1Ref)
    println(name1 === name1)
    println(name1 === name2)
    println(name1 === name1Ref)
}