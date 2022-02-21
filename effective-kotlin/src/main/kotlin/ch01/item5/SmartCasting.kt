package ch01.item5

open class OutFit {
    override fun toString(): String {
        return "OutFit()"
    }
}

class Dress : OutFit() {
    override fun toString(): String {
        return "Dress()"
    }
}

class Person(val outfit: OutFit)
class Person2(val email: String?)

fun changeDress(person: Person) {
    require(person.outfit is Dress)
    val dress: Dress = person.outfit
    println(dress)
}

fun sendEmail(person: Person2, message: String) {
    require(person.email != null)
    val email: String = person.email
    println(email)
}

fun main() {
//    changeDress(Person(OutFit())) // IllegalArgumentException
    changeDress(Person(Dress())) // Dress()
    sendEmail(Person2("person@email.com"), "hello world")
}