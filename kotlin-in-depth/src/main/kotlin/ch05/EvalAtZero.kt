package ch05

fun evalAtZero(f: (Int) -> Int) = f(0)

fun evalAtZero(n: Int, f:(Int) -> Int) = f(n)

fun inc(n: Int) = n + 1

fun dec(n: Int) = n - 1

fun main() {
    println(evalAtZero(::inc))
    println(evalAtZero(::dec))
    println(evalAtZero(10, ::inc))
}