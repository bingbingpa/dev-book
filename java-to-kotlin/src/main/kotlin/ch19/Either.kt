package ch19

sealed class Either<out L, out R>

data class Left<out L>(val l: L) : Either<L, Nothing>()

data class Right<out R>(val r: R) : Either<Nothing, R>()

fun parseInt(s: String): Either<String, Int> = try {
    Right(Integer.parseInt(s))
} catch (exception: Exception) {
    Left(exception.message ?: "No message")
}

fun doubleString(s: String): Either<String, Int> {
    return when (val result: Either<String, Int> = parseInt(s)) {
        is Right -> Right(2 * result.r)
        is Left -> result
    }
}

inline fun <L, R1, R2> Either<L, R1>.map(f: (R1) -> R2): Either<L, R2> =
    when (this) {
        is Right -> Right(f(this.r))
        is Left -> this
    }

inline fun <L, R1, R2> Either<L, R1>.flatMap(
    f: (R1) -> Either<L, R2>
): Either<L, R2> =
    when (this) {
        is Right -> f(this.r)
        is Left -> this
    }

fun doubleString2(s: String): Either<String, Int> = parseInt(s).map { 2 * it }

fun main() {
    when (val result: Either<String, Int> = parseInt(readlnOrNull() ?: "")) {
        is Right -> println("Your number was ${result.r}")
        is Left -> println("I couldn't read your number because ${result.l}")
    }
}

