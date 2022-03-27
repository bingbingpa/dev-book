package ch05

class Address(
    var zipCode: Int = 0,
    var city: String = "",
    var street: String = "",
    var house: String = ""
) {
    fun post(message: String): Boolean {
        "Message for {$zipCode, $city, $street, $house}: $message"
        print("입력하세요: ")
        return readLine() == "OK"
    }

    fun showCityAddress() = println("$street, $house")

    fun asText() = "$city, $street, $house"
}

fun main() {
    val _zipCode = 123456
    val _city = "London"
    val _street = "Baker Street"
    val _house = "22lb"
    val isReceived = Address().run {
        // Address 인스턴스를 this 로 사용
        zipCode = _zipCode
        city = _city
        street = _street
        house = _house
        post("Hello")
    }

    if (!isReceived) {
        println("Message is not delivered")
    }

    Address().run {
        // Address 인스턴스를 this 로 사용
        zipCode = _zipCode
        city = _city
        street = _street
        house = _house
        showCityAddress()
    }

    val message = with(Address(_zipCode, _city, _street, "222b")) {
        "Address: $city, $street, $house"
    }
    println(message)

    val address = run {
        val city = readLine() ?: return
        val street = readLine() ?: return
        val house = readLine() ?: return
        Address(city = city, street = street, house = house)
    }

    println(address.asText())
}