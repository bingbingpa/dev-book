package ch06.item40

class Complex(
    val real: Double,
    val imaginary: Double
) {
    override fun equals(other: Any?): Boolean {
        if (other is Double) {
            return imaginary == 0.0 && real == other
        }
        return other is Complex && real == other.real && imaginary == other.imaginary
    }
}

fun main() {
    val complex = Complex(1.0, 0.0)
    println(complex.equals(1.0))
    println(1.0.equals(complex))

    val list = listOf<Any>(complex)
    list.contains(1.0)
}