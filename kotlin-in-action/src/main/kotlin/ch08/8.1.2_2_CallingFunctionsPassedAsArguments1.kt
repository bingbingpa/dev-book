package ch08.ex1_2_2_CallingFunctionsPassedAsArguments1

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in indices) {
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}

fun main() {
    println("ab1c".filter { it in 'a'..'z' })
}