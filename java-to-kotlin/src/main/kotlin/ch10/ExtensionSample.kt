package ch10

open class Base {
    open fun doit() { println("Base.doit") }
}

class Derived : Base() {
    override fun doit() { println("Derived.doit") }
}

fun Derived.foo() { println("Derived.foo extension"); doit() }
fun Base.foo() { println("Base.foo extension"); doit()}

fun main() {
    val base: Base = Base()
    val derived: Derived = Derived()
    val base2: Base = derived

    base.foo()
    derived.foo()
    base2.foo()

    /** 실행 결과
     * Base.foo extension
     * Base.doit
     * Derived.foo extension
     * Derived.doit
     * Base.foo extension
     * Derived.doit
     */
}