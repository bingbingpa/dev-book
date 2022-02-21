package ch01.item2

fun primeNumber1() {
    var numbers = (2..100).toList()
    val primes = mutableListOf<Int>()
    while (numbers.isNotEmpty()) {
        val prime = numbers.first()
        primes.add(prime)
        numbers = numbers.filter { it % prime != 0 }
    }
    println(primes)
}

fun primeNumber2() {
    val primes: Sequence<Int> = sequence {
        var numbers = generateSequence(2) { it + 1}
        while (true) {
            val prime = numbers.first()
            yield(prime)
            numbers = numbers.drop(1)
                .filter { it % prime != 0 }
        }
    }
    println(primes.take(10).toList())
}

fun primeNumber3() {
    val primes: Sequence<Int> = sequence {
        var numbers = generateSequence(2) { it + 1}
        var prime: Int
        while (true) {
            prime = numbers.first()
            yield(prime)
            numbers = numbers.drop(1)
                .filter { it % prime != 0 }
        }
    }
    // 이상하게 결과가 나온다.
    println(primes.take(10).toList())
}

fun main() {
    primeNumber1()
    primeNumber2()
    primeNumber3()
}