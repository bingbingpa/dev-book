package ch05

interface Truncated {
    val truncated: String
    val original: String
}

private fun String.truncator(max: Int) = object: Truncated {
    override val truncated
        get() = if(length <= max) this@truncator else substring(0, max)

    override val original
        get() = this@truncator
}

fun main() {
    val truncator = "Hello".truncator(3)

    println(truncator.original)
    println(truncator.truncated)
}