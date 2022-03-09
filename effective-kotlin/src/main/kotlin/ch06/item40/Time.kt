package ch06.item40

class Time(
    val millisArg: Long = -1,
    val isNow: Boolean = false
) {
    val millis: Long get() =
        if (isNow) System.currentTimeMillis()
        else millisArg

    override fun equals(other: Any?): Boolean =
        other is Time && millis == other.millis
}

//sealed class Time
//data class TimePoint(val millis: Long): Time()
//object Now: Time()

fun main() {
    val now = Time(isNow = true)
    println(now == now)
    List(100000) { now }.all { it == now }.also { println(it) }

    val now1 = Time(isNow = true)
    val now2 = Time(isNow = true)
    println(now1 == now2)
}