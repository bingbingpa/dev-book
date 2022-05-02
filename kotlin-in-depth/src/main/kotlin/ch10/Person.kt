package ch10

class Person(val firstName: String, val familyName: String) {
    fun fullName(familyFirst: Boolean): String = if (familyFirst) {
        "$familyName $firstName"
    } else {
        "$firstName $familyName"
    }
}

class Empty

fun main() {
    val personClass = Class.forName("ch10.Person").kotlin
    val person = personClass.constructors.first().call("John", "Doe")
    val fullNameFun = personClass.members.first { it.name == "fullName" }

    println(fullNameFun.call(person, false))

    val emptyClass = Class.forName("ch10.Empty").kotlin

    println(emptyClass.constructors.first())
    println(emptyClass.objectInstance)

}