package ch02.item16

class Properties {
    var name: String? = null
        get() = field?.uppercase()
        set(value) {
            if (!value.isNullOrBlank()) {
                field = value
            }
        }
}

fun main() {
    val properties = Properties()
    properties.name = null
    println(properties.name)
    properties.name = "abcd"
    println(properties.name)
}