package ch01.item4

open class Animal

class Zebra: Animal()

fun main() {
//    var animal = Zebra()
//    animal = Animal() // 컴파일 오류: Type mismatch
    var animal: Animal = Zebra()
    animal = Animal()
}