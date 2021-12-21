package ch02

class Person(
    val name: String,
    var isMarried: Boolean
)

fun main() {
    val person = Person("Bob", true)
    person.isMarried = false
    println(person.isMarried)

}
