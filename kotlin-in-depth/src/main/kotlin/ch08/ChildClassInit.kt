package ch08

open class Vehicle {
    init {
        println("Initializing Vehicle")
    }
}

open class Car : Vehicle() {
    init {
        println("Initializing Car")
    }
}

class Truck : Car() {
    init {
        println("Initializing Truck")
    }
}

fun main() {
    Truck()
}