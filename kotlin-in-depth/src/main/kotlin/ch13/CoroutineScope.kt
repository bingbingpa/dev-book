package ch13

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        println("Custom scope start")

        coroutineScope {
            launch {
                delay(100)
                println("Task 1 finished")
            }

            launch {
                delay(100)
                println("Task 2 finished")
            }
        }

        println("Custom scope end")
    }
}