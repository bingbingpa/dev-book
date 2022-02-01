package ch10.ex2_1_2_ReflectionAPI1

import kotlin.reflect.KFunction2

fun foo(x: Int) = println(x)

fun sum(x: Int, y: Int) = x + y

fun main() {
    val kFunction = ::foo
    kFunction.call(42)

    val kFunction2: KFunction2<Int, Int, Int> = ::sum
    println(kFunction2.invoke(1, 2) + kFunction2(3, 4))
}
