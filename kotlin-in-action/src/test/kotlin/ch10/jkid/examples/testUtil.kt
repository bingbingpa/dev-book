package ch10.jkid.examples.jsonSerializerTest

import ch10.jkid.deserialization.deserialize
import ch10.jkid.serialization.serialize
import kotlin.test.assertEquals

inline fun <reified T: Any> testJsonSerializer(value: T, json: String) {

    assertEquals(json, serialize(value))

    assertEquals(value, deserialize(json))
}