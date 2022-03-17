package ch06.item42

data class User1(val name: String, val surname: String) {
    companion object {
        val DISPLAY_ORDER = compareBy(User1::surname, User1::name)
    }
}

class User2(val name: String, val surname: String) : Comparable<User2> {
    override fun compareTo(other: User2): Int =
        compareValues(surname, other.surname)
}

class User3(val name: String, val surname: String) : Comparable<User3> {
    override fun compareTo(other: User3): Int =
        compareValuesBy(this, other, { it.surname }, { it.name })
}

fun main() {
    val names = listOf(
        User1("def", "456"),
        User1("abc", "123")
    )

    names.sortedWith(User1.DISPLAY_ORDER).also { println(it) }
}
