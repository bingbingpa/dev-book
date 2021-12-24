package ch04

interface User {
    val nickname: String
}

class PrivateUser(override val nickname: String) : User

class SubscribingUser(private val email: String) : User {
    override val nickname: String
        get() = email.substringBefore('@')
}

class FacebookUser(accountId: Int) : User {
    override val nickname = "fb:$accountId"
}

fun main() {
    println(PrivateUser("test@kotlinglang.org").nickname)
    println(SubscribingUser("test@kotlinglang.org").nickname)
    println(FacebookUser(1).nickname)
}
