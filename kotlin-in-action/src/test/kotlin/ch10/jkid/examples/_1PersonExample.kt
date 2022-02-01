package ch10.jkid.examples.simple

import ch10.jkid.deserialization.deserialize
import ch10.jkid.serialization.serialize
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

data class Person(val name: String, val age: Int)

class PersonTest {
    @Test fun test() {
        val person = Person("Alice", 29)
        val json = """{"age": 29, "name": "Alice"}"""

        assertEquals(json, serialize(person))
        assertEquals(person, deserialize(json))
    }
}