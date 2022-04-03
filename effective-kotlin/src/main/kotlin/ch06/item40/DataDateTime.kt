package ch06.item40.DataDateTime

data class Date(
    val yer: Int,
    val month: Int,
    val day: Int
)

data class DateTime(
    val date: Date,
    val hour: Int,
    val minute: Int,
    val second: Int
)

fun main() {
    val o1 = DateTime(Date(1992, 10, 20), 12, 30, 0)
    val o2 = Date(1992, 10, 20)
    val o3 = DateTime(Date(1992, 10, 20), 14, 45, 30)

    println(o1.equals(o2)) // false
    println(o2.equals(o3)) // false
    println(o1 == o3) // false

    println(o1.date.equals(o2)) // true
    println(o2.equals(o3.date)) // true
    println(o1.date == o3.date) // true
}