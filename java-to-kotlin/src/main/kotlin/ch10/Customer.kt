package ch10

data class Customer(
    val id: String,
    val givenName: String,
    val familyName: String
) {
    val fullName get() = "$givenName $familyName"
    fun nameForMarketing() = "${familyName.uppercase()}, $givenName"
}

fun main() {
    val methodReference: (Customer.() -> String) =
        Customer::fullName
    val extensionFunctionReference: (Customer.() -> String) =
        Customer::nameForMarketing

    val methodAsFunctionReference: (Customer) -> String =
        methodReference
    val extensionAsFunctionReference: (Customer) -> String =
        extensionFunctionReference

    val customer = Customer("1", "aaa", "bbb")

    println(customer.methodReference())
    println(customer.extensionFunctionReference())

    println(methodAsFunctionReference(customer))
    println(extensionAsFunctionReference(customer))
}