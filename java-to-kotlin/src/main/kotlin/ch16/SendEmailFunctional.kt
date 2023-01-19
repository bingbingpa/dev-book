package ch16

fun createEmailSender3(
    serverAddress: InetAddress,
    username: String,
    password: String
): (Email) -> Unit {
    fun result(email: Email) {
        sendEmail(
            email,
            serverAddress,
            username,
            password
        )
    }
    return ::result
}

fun createEmailSender4(
    serverAddress: InetAddress,
    username: String,
    password: String
): (Email) -> Unit {
    val result: (Email) -> Unit =
        { email ->
            sendEmail(
                email,
                serverAddress,
                username,
                password
            )
        }
    return result
}

fun createEmailSender5(
    serverAddress: InetAddress,
    username: String,
    password: String
): (Email) -> Unit =
    { email ->
        sendEmail(
            email,
            serverAddress,
            username,
            password
        )
    }

val sender: (Email) -> Unit = createEmailSender5(
    InetAddress("smtp.travelator.com"),
    "username",
    "password"
)
