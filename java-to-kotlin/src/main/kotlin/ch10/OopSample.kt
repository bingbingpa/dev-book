package ch10

open class Parent {
    fun a() {
        print(b())
    }

    open fun b() = "parent"
}

class Child : Parent() {
    override fun b() = "child"
}

fun main() {
    val a: Parent = Child()
    a.a()
}