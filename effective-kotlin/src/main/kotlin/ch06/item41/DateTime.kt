package ch06.item41

import java.util.*

class DateTime(
    private var millis: Long = 0L,
    private var timeZone: TimeZone? = null
) {
    private var asStringCache = ""
    private var changed = false

    override fun equals(other: Any?): Boolean =
        other is DateTime &&
                other.millis == millis &&
                other.timeZone == timeZone

    override fun hashCode(): Int {
        Objects.hash()
        var result = millis.hashCode()
        result = result * 31 + timeZone.hashCode()
        return result
    }
}

inline fun hashCodeOf(vararg values: Any?) =
    values.fold(0) { acc, value ->
        (acc * 31) + value.hashCode()
    }