package ch02.item12

// 이 경우는 곱셈의 결과로 ()-> Unit. 즉, 함수를 생성한다.
//operator fun Int.times(operation: () -> Unit): () -> Unit = { repeat(this) { operation() } }

// 이 경우는 곱셈의 결과가 Unit 이고, 함수를 호출한다.
operator fun Int.times(operation: () -> Unit) {
    repeat(this) { operation() }
}

infix fun Int.timesRepeated(operation: ()->Unit) = {
    repeat(this) { operation}
}

fun main() {
//    val tripledHello = 3 * { print("Hello")}
//    tripledHello() //HelloHelloHello
    3 * { print("Hello") } //HelloHelloHello

    val tripleHello = 3 timesRepeated { print("Hello")}
    tripleHello()
}