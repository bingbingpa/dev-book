package ch13

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    runBlocking {
        val streamSize = 5
        val channel = Channel<Int>(3)

        launch {
            for (n in 1..streamSize) {
                delay(Random.nextLong(100))
                val square = n * n
                println("Sending: $square")
                channel.send(square)
            }
        }

        launch {
            for (i in 1..streamSize) {
                delay(Random.nextLong(100))
                val n = channel.receive()
                println("Receiving: $n")
            }
        }
    }
}