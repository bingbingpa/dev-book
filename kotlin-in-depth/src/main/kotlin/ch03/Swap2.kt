package ch03

fun main() {
    val args = listOf("Hello", "world", "kotlin")

    fun swap(i: Int, j: Int): String {
        val chars = args[0].toCharArray()
        val tmp = chars[i]
        chars[i] = chars[j]
        chars[j] = tmp
        return chars.concatToString()
    }

    println(swap(0, args[0].lastIndex))
}
