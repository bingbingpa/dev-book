package ch06.item41

class Proper(val name: String) {

    override fun equals(other: Any?): Boolean {
        equalsCounter++
        return other is Proper && name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    companion object {
        var equalsCounter = 0
    }
}

class Terrible(val name: String) {
    override fun equals(other: Any?): Boolean {
        equalsCounter++
        return other is Terrible && name == other.name
    }

    override fun hashCode() = 0

    companion object {
        var equalsCounter = 0
    }
}

fun main() {
    val properSet = List(10000) { Proper("$it") }.toSet()
    println(Proper.equalsCounter)
    val terribleSet = List(10000) { Terrible("$it") }.toSet()
    println(Terrible.equalsCounter)

    Proper.equalsCounter = 0
    println(Proper("9999") in properSet)
    println(Proper.equalsCounter)

    Proper.equalsCounter = 0
    println(Proper("A") in properSet)
    println(Proper.equalsCounter)

    Terrible.equalsCounter = 0
    println(Terrible("9999") in terribleSet)
    println(Terrible.equalsCounter)

    Terrible.equalsCounter = 0
    println(Terrible("A") in terribleSet)
    println(Terrible.equalsCounter)
}
