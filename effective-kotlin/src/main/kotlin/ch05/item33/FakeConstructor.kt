package ch05.item33

class A

fun main() {
    val a = A()
    val reference: () ->A = ::A
}