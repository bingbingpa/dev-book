package ch06.item39

//import ch06.item39.ValueMatcher.*

sealed class ValueMatcher<T> {
    abstract fun match(value: T): Boolean
}
    class Equal<T>(val value: T) : ValueMatcher<T>() {
        override fun match(value: T): Boolean =
            value == this.value
    }

    class NotEqual<T>(val value: T) : ValueMatcher<T>() {
        override fun match(value: T): Boolean =
            value != this.value
    }

    class EmptyList<T>() : ValueMatcher<T>() {
        override fun match(value: T): Boolean =
            value is List<*> && value.isEmpty()
    }

    class NotEmptyList<T>() : ValueMatcher<T>() {
        override fun match(value: T): Boolean =
            value is List<*> && value.isNotEmpty()
    }
//}

fun <T> ValueMatcher<T>.reversed() =
    when(this) {
        is EmptyList -> NotEmptyList()
        is NotEmptyList -> EmptyList()
        is Equal -> NotEqual(value)
        is NotEqual -> Equal(value)
    }

fun main() {
    println(Equal(3).match(3))
    println(NotEqual(3).match(1))
    println(EmptyList<Int>().match(3))
    println(NotEmptyList<Int>().match(3))

    println(Equal(3).reversed().match(3))
}