package ch02

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun iterate() {
    for (i in 1..10) {
        println(fizzBuzz(i))
    }
}

fun iterateWithStep() {
    for (i in 100 downTo 1 step 2) {
        println(fizzBuzz(i))
    }
}

fun main() {
    iterate()
    iterateWithStep()
}
