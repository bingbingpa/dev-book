package ch11

import kotlin.properties.Delegates.notNull
import kotlin.properties.Delegates.observable
import kotlin.properties.Delegates.vetoable

class Person(name: String, val age: Int) {
    var name: String by observable(name) { _, old, new ->
        println("Name changed: $old to $new")
    }
}

class CartItem(data: Map<String, Any?>) {
    val title: String by data
    val price: Double by data
    val quantity: Int by data
}

fun main() {
    var num: Int by notNull()
    num = 10
    println(num) // 10

    val person = Person("John", 25)

    person.name = "Harry"
    person.name = "Vincent"
    person.name = "Vincent"

    var password: String by vetoable("password") { _, old, new ->
        if (new.length < 8) {
            println("Password should be at least 8 characters long")
            false
        } else {
            println("Password is OK")
            true
        }
    }
    password = "pAsSwOrD"
    password = "qwerty"

    val item = CartItem(mapOf(
        "title" to "Laptop",
        "price" to 999.9,
        "quantity" to 1
    ))

    println(item.title)
    println(item.price)
    println(item.quantity)

}