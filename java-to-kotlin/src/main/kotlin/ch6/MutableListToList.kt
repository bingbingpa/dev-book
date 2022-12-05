package ch6

class AValueType(val strings: List<String>) {
    val first: String? = strings.firstOrNull()
}

fun main() {
    val aMutableList = mutableListOf("0", "1")
    val aList: List<String> = aMutableList
    val holdState = AValueType(aList)

    println(holdState.first == holdState.strings.first()) // true

    aMutableList[0] = "banana"

    println(holdState.first == holdState.strings.first()) // false
}