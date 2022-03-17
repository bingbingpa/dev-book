package ch06.item43

open class C {
//    open fun foo() = "c"
}
class D: C() {
//    override fun foo() = "d"
}

fun C.foo() = "c"
fun D.foo() = "d"

fun main() {
    val d = D()
    println(d.foo()) // d
    val c: C = d
    println(c.foo()) // c

    println(D().foo()) // d
    println((D() as C).foo()) // c
}