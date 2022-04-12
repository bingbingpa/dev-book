package ch07.item47

@JvmInline
value class Password(private val password: String) {
    init {
        System.out.println("password init")
        if (password.length < 5) {
            throw IllegalArgumentException("패스워드는 5자리 이상이여야 합니다.")
        }
    }

    val validPassword: String
        get() {
            return "**$password**"
        }
}

fun main() {
    val password = Password("123")
    println(password.validPassword)
}

