package ch01.item1

import java.util.SortedSet
import java.util.TreeSet

class FullName(var firstName: String, var lastName: String): Comparable<FullName> {
    override fun compareTo(other: FullName): Int {
        return "${firstName}${lastName}".compareTo("${other.firstName}${other.lastName}")
    }

    override fun toString(): String {
        return "$firstName, $lastName"
    }
}

fun main() {
    val names: SortedSet<FullName> = TreeSet()
    val person = FullName("AAA", "BBB")
    names.add(person)
    names.add(FullName("Jordan", "Hansen"))
    names.add(FullName("David", "Blanc"))

    println(names)
    println(person in names) // true

    person.firstName = "ZZZ"
    println(names)
    println(person in names) // false
}