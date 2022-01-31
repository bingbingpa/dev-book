package ch10.ex2_1_1_ReflectionAPI

import kotlin.reflect.full.memberProperties

class Person(val name: String, val age: Int)

fun main() {
    val person = Person("Alice", 29)
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)
    kClass.memberProperties.forEach { println(it.name) }
}
