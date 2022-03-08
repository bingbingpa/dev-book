package ch03.item24.cupin

class Cup<in T>
open class Dog
class Puppy(): Dog()

fun main() {
//    val b: Cup<Dog> = Cup<Puppy>() // 오류
    val a: Cup<Puppy> = Cup<Dog>() // OK

//    val anys = Cup<Any> = Cup<Int>() // 오류
    val nothings: Cup<Nothing> = Cup<Int>() // OK
}