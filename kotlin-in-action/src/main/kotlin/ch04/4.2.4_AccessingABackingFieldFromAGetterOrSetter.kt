package ch04

class User1(private val name: String) {
    var address: String = "unspecified"
        set(value) {
            println("""
                Address was changed for $name:
                "$field" -> "$value".""".trimIndent())
            field = value
        }

    override fun toString(): String {
        return "User1(name='$name', address='$address')"
    }
}

fun main() {
    val user = User1("Alice")
    user.address = "가산디지털 단지역"
}