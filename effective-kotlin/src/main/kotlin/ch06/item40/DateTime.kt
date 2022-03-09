package ch06.item40

import java.util.TimeZone

class DateTime1(
    private var millis: Long = 0L,
    private var timeZone: TimeZone? = null
) {
    private var asStringCache = ""
    private var changed = false

    override fun equals(other: Any?): Boolean =
        other is DateTime1 &&
                other.millis == millis &&
                other.timeZone == timeZone
}

data class DateTime2(
    private var millis: Long = 0L,
    private var timeZone: TimeZone? = null
) {
    private var asStringCache = ""
    private var changed = false
}

fun main() {
    val dateTime1 = DateTime1(10L, TimeZone.getDefault())
    val dateTime2 = DateTime1(10L, TimeZone.getDefault())
    println(dateTime1 == dateTime2)

    val dateTime3 = DateTime2(10L, TimeZone.getDefault())
    val dateTime4 = DateTime2(10L, TimeZone.getDefault())
    println(dateTime3 == dateTime4)
}