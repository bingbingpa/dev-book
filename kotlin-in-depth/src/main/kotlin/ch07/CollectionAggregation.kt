package ch07.aggregation

class Person(
    val firstName: String,
    val familyName: String,
    val age: Int
) {
    override fun toString() = "$firstName $familyName: $age"
}

val Person.fullName get() = "$firstName $familyName"
val Person.reverseFullName get() = "$familyName $firstName"

val FULL_NAME_COMPARATOR = Comparator<Person> { p1, p2 ->
    p1.fullName.compareTo(p2.fullName)
}

val REVERSE_FULL_NAME_COMPARATOR = Comparator<Person> { p1, p2 ->
    p1.reverseFullName.compareTo(p2.reverseFullName)
}

fun main() {
    val persons = sequenceOf(
        Person("Brook", "Hudson", 25),
        Person("Silver", "Watts", 30),
        Person("Dane", "Hall", 19),
        Person("Val", "Ortiz", 28)
    )

    println(persons.minWithOrNull(FULL_NAME_COMPARATOR)) // Brook Hudson: 25
    println(persons.maxWithOrNull(FULL_NAME_COMPARATOR)) // Val Ortiz: 28
    println(persons.minWithOrNull(REVERSE_FULL_NAME_COMPARATOR)) // Dane Hall: 19
    println(persons.maxWithOrNull(REVERSE_FULL_NAME_COMPARATOR)) // Silver Watts: 30

    val list = listOf(1, 2, 3)
    println(
        list.joinToString(
            limit = 1,
            truncated = "***"
        )
    )

    val (evens, odds) = listOf(1, 2, 3, 4, 5).partition { it % 2 == 0 }
    println(evens) // [2, 4]
    println(odds) // [1, 3, 5]
}