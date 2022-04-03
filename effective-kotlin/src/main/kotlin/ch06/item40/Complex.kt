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
    println(complex.equals(1.0)) // true
    println(1.0.equals(complex)) // false

    val list = listOf<Any>(complex)
    println(list.contains(1.0)) // 현재 JVM 에서는 false. 하지만 컬렉션 구현에 따라서 달라질 수 있으므로 신뢰성이 떨어진다.
}