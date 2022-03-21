package ch05.item33

data class Student(
    val id: Int,
    val name: String,
    val surname: String
)

class StudentsFactory {
    var nextId = 0
    fun next(name: String, surname: String) =
        Student(nextId++, name, surname)
}

fun main() {
    val factory = StudentsFactory()
    val s1 = factory.next("Marcin", "Moskala")
    println(s1)
    val s2 = factory.next("Igor", "Wojda")
    println(s2)
}