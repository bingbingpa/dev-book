package ch06.item37

fun String.parseName(): Pair<String, String>? {
    val indexOfLastSpace = this.trim().lastIndexOf(' ')
    if(indexOfLastSpace < 0) return null
    val firstName = this.take(indexOfLastSpace)
    val lastName = this.drop(indexOfLastSpace)
    return Pair(firstName, lastName)
}

data class FullName(
    val firstName: String,
    val lastName: String
)

fun String.parseName2(): FullName? {
    val indexOfLastSpace = this.trim().lastIndexOf(' ')
    if(indexOfLastSpace < 0) return null
    val firstName = this.take(indexOfLastSpace)
    val lastName = this.drop(indexOfLastSpace)
    return FullName(firstName, lastName)
}

fun main() {
    val fullName = "SeungHyn Park"
    val (firstName, lastName) = fullName.parseName() ?: return
    println("$firstName $lastName")

    val fullName2 = "SeungHyn Park"
    val (firstName2, lastName2) = fullName2.parseName2() ?: return
    println("$firstName2 $lastName2")
}