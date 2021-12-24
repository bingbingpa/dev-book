package ch04


data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
        override fun compare(p0: Person, p1: Person): Int =
            p0.name.compareTo(p1.name)
    }
}

fun main() {
    val persons = listOf(Person("Bob"), Person("Alice"))
    println(persons.sortedWith(Person.NameComparator))
}