package ru.yole.jkid.exercise

import ch10.jkid.deserialization.deserialize
import ch10.jkid.exercise.DateFormat
import ch10.jkid.serialization.serialize
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.text.SimpleDateFormat
import java.util.*
import kotlin.test.assertEquals

data class Person(
        val name: String,
        @DateFormat("dd-MM-yyyy") val birthDate: Date
)

@Disabled
class DateFormatTest {
    private val value = Person("Alice", SimpleDateFormat("dd-MM-yyyy").parse("13-02-1987"))
    private val json = """{"birthDate": "13-02-1987", "name": "Alice"}"""

    @Test fun testSerialization() {
        assertEquals(json, serialize(value))
    }

    @Test fun testDeserialization() {
        assertEquals(value, deserialize(json))
    }
}
