package ch05

class Address {
    var zipCode: Int = 0
    var city: String = ""
    var street: String = ""
    var house: String = ""

    fun post(message: String): Boolean {
        println("Message for {$zipCode, $city, $street, $house}: $message")
        return readLine() == "OK"
    }
}

fun main() {
    val isReceived = Address().run {
        zipCode = 123456
        city = "London"
        street = "Baker Street"
        house = "22lb"
        post("Hello")
    }

    println(isReceived)

    if (!isReceived) {
        println("Message is not delivered")
    }
}