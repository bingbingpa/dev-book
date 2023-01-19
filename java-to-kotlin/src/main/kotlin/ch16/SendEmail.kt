package ch16

interface ISendEmail {
    fun send(email: Email)
}

class EmailSender : ISendEmail {
    override fun send(email: Email) {
        TODO("Not yet implemented")
    }
}

fun createEmailSender(
    serverAddress: InetAddress,
    username: String,
    password: String
): ISendEmail {
    return object : ISendEmail {
        override fun send(email: Email) {
            sendEmail(
                email,
                serverAddress,
                username,
                password
            )
        }
    }
}

fun interface ISendEmail2 {
    fun send(email: Email)
}

fun createEmailSender2(
    serverAddress: InetAddress,
    username: String,
    password: String
): ISendEmail2 {
    return ISendEmail2 { email ->
        sendEmail(
            email,
            serverAddress,
            username,
            password
        )
    }
}

fun sendEmail(
    email: Email,
    serverAddress: InetAddress,
    username: String,
    password: String
) {

}