package ch05.classExtension

class Address(val city: String, val street: String, val house: String)

class Person(val firstName: String, val familyName: String) {
    fun Address.post(message: String) {
        // 암시적 this: 확장 수신 객체(Address)
        val city = city
        // 한정시키지 않은 this: 확장 수신 객체(Address)
        val street = this.city
        // 한정시킨 this: 확장 수신 객체(Address)
        val house = this@post.house
        // 암시적 this: 디스패치 수신 객체(Person)
        val firstName = firstName
        // 한정시킨 this: 디스패치 수신 객체(Person)
        val familyName = this@Person.familyName

        println("From $firstName, $familyName, at $city, $street, $house")
        println(message)
    }

    fun test(address: Address) {
        address.post("Hello")
    }
}


fun main() {
    with(Person("first", "family")) {
        this.test(
            Address("London", "Baker Street", "221b")
        )
    }
}
