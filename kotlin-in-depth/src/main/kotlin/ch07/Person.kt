package ch07

class Person(
    val firstName: String,
    val familyName: String,
    val age: Int,
) : Comparable<Person> {
    val fullName get() = "$firstName $familyName"
    override fun compareTo(other: Person) = fullName.compareTo(other.fullName)

    companion object {
        val AGE_COMPARATOR = Comparator<Person> {p1, p2 ->
            p1.age.compareTo(p2.age)
        }
        val REVERSE_AGE_COMPARATOR = compareByDescending<Person> { it.age }
    }
}

fun main() {
    val p1 = Person("aaa", "bb", 20)
    val p2 = Person("bbb", "cc", 10)

    println(p1 < p2)
    println(Person.AGE_COMPARATOR.compare(p1, p2))
}