package ch10.jkid.deserialization

data class Author(val name: String)
data class Book(val title: String, val author: Author)

fun main() {
    val json = """{"title": "Catch-22", "author": {"name": "J. Heller"}}"""
    println(deserialize<Book>(json))
}
