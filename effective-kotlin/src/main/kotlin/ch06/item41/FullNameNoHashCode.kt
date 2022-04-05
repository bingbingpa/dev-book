package ch06.item41.noHashCode


class FullName(
    var name: String,
    var surname: String
) {
    override fun equals(other: Any?): Boolean =
        other is FullName
                && other.name == name
                && other.surname == surname
}

fun main() {
    val s = mutableSetOf<FullName>()
    s.add(FullName("Hello", "World"))
    val p = FullName("Hello", "World")
    println(p in s) // false
    println(p == s.first()) // true
}