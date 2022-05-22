package ch13

import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
    runBlocking {
        val ticker = ticker(100)
        println(withTimeoutOrNull(50) { ticker.receive() })
        println(withTimeoutOrNull(60) { ticker.receive() })
        delay(250)
        println(withTimeoutOrNull(1) { ticker.receive() })
        println(withTimeoutOrNull(60) { ticker.receive() })
        println(withTimeoutOrNull(60) { ticker.receive() })
    }
}