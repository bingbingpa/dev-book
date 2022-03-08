package ch06.item40

open class Animal
class Book
class Cat: Animal()

fun main() {
//    Animal() == Book() // 오류
//    Animal() === Book() // 오류

    Animal() == Cat()
    Animal() === Cat()
}