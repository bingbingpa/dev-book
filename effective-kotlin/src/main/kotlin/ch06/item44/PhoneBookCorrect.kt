package ch06.item44

class PhoneBookCorrect {
    fun String.isPhoneNumber() =
        length == 7 && all { it.isDigit() }
}

class A {
    val a = 10
}

class B {
    val a = 20
    val b = 30

    fun A.test() = a + b
}


fun main() {
    PhoneBookCorrect().apply { "1234567890".isPhoneNumber() }

    B().apply { println(A().test()) } // 40
}