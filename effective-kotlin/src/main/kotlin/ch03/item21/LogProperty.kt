package ch03.item21

var token: String? = null
    get() {
        println("token returned value $field")
        return field
    }
    set(value) {
        println("token changed from $field to $value")
        field = value
    }
var attempts: Int = 0
    get() {
        println("attempts returned value $field")
        return field
    }
    set(value) {
        println("attempts changed from $field to $value")
        field = value
    }

fun main() {
    token = "test"
    println(token)
    attempts = 13
    println(attempts)
}
