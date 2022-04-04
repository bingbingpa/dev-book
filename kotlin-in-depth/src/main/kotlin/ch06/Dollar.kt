package ch06

@JvmInline
value class Dollar(val amount: Int) {
    fun add(d: Dollar) = Dollar(amount + d.amount)
    val isDebt get() = amount < 0
}

fun safeAmount(dollar: Dollar?) = dollar?.amount ?: 0

fun main() {
    println(Dollar(15).add(Dollar(20)).amount)
    println(Dollar(-100).isDebt)
    println(Dollar(15).amount) // 인라인됨
    println(Dollar(15)) // Any? 로 사용되기 때문에 인라인되지 않음
    println(safeAmount(Dollar((15)))) // Dollar? 로 사용되기 때문에 인라인 되지 않음
}