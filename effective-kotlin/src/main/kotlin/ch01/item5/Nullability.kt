package ch01.item5

fun sendEmailReturn(person: Person2, text: String) {
    val email: String = person.email ?: return
    println(email)
}

fun sendEmailLog(person: Person2, text: String) {
    val email: String = person.email ?: run {
        log("Email not sent, no email address")
        return
    }
}

private fun log(text: String) {
    println(text)
}

fun main() {
    sendEmailReturn(Person2("person@email.com"), "text") // person@email.com
    sendEmailReturn(Person2(null), "text") // 아무것도 출력하지 않고 return
    sendEmailLog(Person2(null), "text") // Email not sent, no email address
}