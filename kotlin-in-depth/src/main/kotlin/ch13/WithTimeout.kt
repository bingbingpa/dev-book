package ch13

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import java.io.File

fun main() {
    runBlocking {
        val asyncData = async { File("src/main/kotlin/ch13/data.txt").readText() }
        try {
            val text = withTimeout(1) { asyncData.await() }
            println("data loaded: $text")
        } catch (e: Exception) {
            println("Timeout exceeded")
        }
    }
}