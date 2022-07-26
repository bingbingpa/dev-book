package ch10.jkid.examples.customSerializerTest

import ch10.jkid.CustomSerializer
import ch10.jkid.ValueSerializer
import ch10.jkid.examples.jsonSerializerTest.testJsonSerializer
import org.junit.jupiter.api.Test
import java.text.SimpleDateFormat
import java.util.*

object DateSerializer : ValueSerializer<Date> {
    private val dateFormat = SimpleDateFormat("dd-mm-yyyy")

    override fun toJsonValue(value: Date): Any? =
            dateFormat.format(value)

    override fun fromJsonValue(jsonValue: Any?): Date =
            dateFormat.parse(jsonValue as String)
}

data class Person(
        val name: String,
        @CustomSerializer(DateSerializer::class) val birthDate: Date
)

class DateSerializerTest {
    @Test fun test() = testJsonSerializer(
            value = Person("Alice", SimpleDateFormat("dd-mm-yyyy").parse("13-02-1987")),
            json = """{"birthDate": "13-02-1987", "name": "Alice"}"""
    )
}