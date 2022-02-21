package ch01.item7

inline fun <reified T> String.readObjectOrNull(obj: T): T? {
    val incorrectSign = false
    if (incorrectSign) {
        return null
    }
    return obj
}

inline fun <reified T> String.readObject(obj: T): Result<T> {
    val incorrectSign = false
    if (incorrectSign) {
        return Failure(JsonParsingException())
    }
    return Success(obj)
}

sealed class Result<out T>

class Success<out T>(val result: T): Result<T>()

class Failure(val throwable: Throwable) : Result<Nothing>()

class JsonParsingException: Exception()
