package ch11.customgetdelegates

import kotlin.reflect.KProperty

class CachedProperty<in R, out T : Any>(val initializer: R.() -> T) {
    private val cachedValues = HashMap<R, T>()

    operator fun getValue(receiver: R, property: KProperty<*>): T {
        return cachedValues.getOrPut(receiver) { receiver.initializer() }
    }
}

fun <R, T : Any> cached(initializer: R.() -> T) = CachedProperty(initializer)

class Person(val firstName: String, val familyName: String)

val Person.fullName: String by cached { "$firstName $familyName" }

fun main() {
    val johnDoe = Person("John", "Doe")
    val harrySmith = Person("Harry", "smith")

    println(johnDoe.fullName)

    println(harrySmith.fullName)

    println(johnDoe.fullName)

    println(harrySmith.fullName)
}