package ch04

class Person {
    val firstName: String
    val familyName: String

    constructor(firstName: String, familyName: String) {
        this.firstName = firstName
        this.familyName = familyName
    }

    constructor(fullName: String) {
        val names = fullName.split(" ")
        if (names.size != 2) {
            throw IllegalArgumentException("Invalid name: $fullName")
        }
        this.firstName = names[0]
        this.familyName = names[1]
    }
}

class Person2(val firstName: String, val familyName: String) {
    inner class Possesion(val description: String) {
        fun showOwner() = println(fullName())
    }
    private fun fullName() = "$firstName $familyName"
}

fun main() {
    val person = Person2("John", "Doe")
    val wallet = person.Possesion("Wallet")
    wallet.showOwner()
}


