package ch04

data class Client(val name: String, val postalCode: Int)

fun main() {
    val client = Client("Bob", 12345)
    val copy = client.copy(postalCode = 99999)
    println("copy = $copy")
}