package ch03.item24

class Cup<out T>
open class Dog
class Puppy: Dog()

fun main() {
    val b: Cup<Dog> = Cup<Puppy>() // OK
//    val a: Cup<Puppy> = Cup<Dog>() // 오류
    val anys: Cup<Any> = Cup<Int>( ) // OK
//    val nothing: Cup<Nothing> = Cup<Int>() // 오류
}