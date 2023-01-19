package ch16

data class Email(
    val to: EmailAddress,
    val from: EmailAddress,
    val subject: String,
    val body: String
)

class EmailAddress

class InetAddress(
    address: String
)