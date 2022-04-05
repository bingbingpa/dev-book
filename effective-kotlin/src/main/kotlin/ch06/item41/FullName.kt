package ch06.item41

data class FullName(
    var name: String,
    var surname: String
)

fun main() {
    val person = FullName("Hello", "World")
    val s = mutableSetOf<FullName>()
    s.add(person)
    person.name = "Bye"
    println(person) // FullName(name=Bye, surname=World)
    println(person in s) // false
    println(s.first() == person) // true
}