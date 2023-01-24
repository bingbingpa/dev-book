package ch16

fun createEmailSender6(
    serverAddress: InetAddress2,
    username: String,
    password: String
): (Email2) -> Unit =
    { email ->
        sendEmail2(
            email,
            serverAddress,
            username,
            password
        )
    }


data class Email2(
    val to: EmailAddress2,
    val from: EmailAddress2,
    val subject: String,
    val body: String
)

class EmailAddress2

class InetAddress2(
    address: String
)

fun sendEmail2(
    email: Email2,
    serverAddress: InetAddress2,
    username: String,
    password: String
) {

}