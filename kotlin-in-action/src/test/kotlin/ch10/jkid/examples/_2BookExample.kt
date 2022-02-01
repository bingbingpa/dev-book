package ch10.jkid.examples.innerObjectTest

import ch10.jkid.examples.jsonSerializerTest.testJsonSerializer
import org.junit.jupiter.api.Test

data class Author(val fullName: String)
data class Book(val name: String, val authors: List<Author>)


class BookTest {
    @Test fun test() = testJsonSerializer(
            value = Book("Lord of the Rings", listOf(Author("J.R.R.Tolkien"))),
            json = """{"authors": [{"fullName": "J.R.R.Tolkien"}], "name": "Lord of the Rings"}"""
    )
}