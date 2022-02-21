package ch01.item5

class Point
class Cluster
class User(val email: String)

fun factorial(n: Int): Long {
//    require(n >= 0)
    require(n >= 0) { "Cannot calculate factorial of $n because it is smaller than 0"}
    return if( n<= 1) 1 else factorial(n - 1) * n
}

fun findClusters(points: List<Point>): List<Cluster> {
    require(points.isNotEmpty())
    return emptyList()
}

fun sendEmail(user: User, message: String) {
    requireNotNull(user.email)
    require(isValidEmail(user.email))
}

private fun isValidEmail(email: String) = email.isNotEmpty()

fun main() {
    // Failed requirement exception 발생
    factorial(-10)
    findClusters(emptyList())
    sendEmail(User(""), "message")
}