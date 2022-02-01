package ch10.jkid.examples.annotationsTest

import ch10.jkid.JsonExclude
import ch10.jkid.JsonName
import ch10.jkid.examples.jsonSerializerTest.testJsonSerializer
import org.junit.jupiter.api.Test

data class Person(
    @JsonName(name = "first_name") val firstName: String,
    @JsonExclude val age: Int? = null
)

class AnnotationsTest {
    @Test fun test() = testJsonSerializer(
            value = Person("Alice"),
            json = """{"first_name": "Alice"}"""
    )
}