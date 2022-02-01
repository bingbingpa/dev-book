package ch10.jkid.examples.rule

import ch10.jkid.serialization.serialize
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.io.File
import kotlin.test.assertEquals

data class Person(val name: String, val age: Int)

class WriteJsonToFileTest {
    @TempDir
    lateinit var folder: File

    @Test fun testUsingTempFolder() {
        val person = Person("Alice", 29)
        val json = """{"age": 29, "name": "Alice"}"""

        val jsonFile = folder.resolve("person.json")
        jsonFile.writeText(serialize(person))
        assertEquals(json, jsonFile.readText())
    }
}