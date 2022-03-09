package ch06.item40

class User(
    val id: Int,
    val name: String,
    val surname: String
) {
    override fun equals(other: Any?): Boolean =
        other is User && other.id == id

    override fun hashCode(): Int = id
}

fun main() {
    val user1 = User(1, "name1", "surname1")
    val user2 = User(1, "name2", "surname2")

    println(user1 == user2)
    println(user1 === user2)
}