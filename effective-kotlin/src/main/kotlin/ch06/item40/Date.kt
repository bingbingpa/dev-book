package ch06.item40.equals3

open class Date(
    val year: Int,
    val month: Int,
    val day: Int
) {
    override fun equals(o: Any?): Boolean = when (o) {
        is DateTime -> this == o.date
        is Date -> o.day == day && o.month == month && year == o.year
        else -> false
    }
}

class DateTime(
    val date: Date,
    val hour: Int,
    val minute: Int,
    val second: Int
) : Date(date.year, date.month, date.day) {
    override fun equals(o: Any?): Boolean = when (o) {
        is DateTime -> o.date == date && o.hour == hour && o.minute == minute && o.second == second
        is Date -> date == o
        else -> false
    }
}

fun main() {
    val o1 = DateTime(Date(1992, 10, 20), 12, 30, 0)
    val o2 = Date(1992, 10, 20)
    val o3 = DateTime(Date(1992, 10, 20), 14, 45, 30)

    println(o1 == o2) // true
    println(o2 == o3) // true
    println(o1 == o3) // false
}

