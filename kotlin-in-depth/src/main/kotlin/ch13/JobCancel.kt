package ch13

import kotlinx.coroutines.*

suspend fun main() {
    val squarePrinter = GlobalScope.launch(Dispatchers.Default) {
        var i = 1
        while (isActive) {
            println(i++)
        }
    }

    delay(100)
    squarePrinter.cancel()
}