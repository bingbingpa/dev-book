package ch02

fun eval2(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval2(e.left) + eval2(e.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun main() {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
}