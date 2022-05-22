package ch13

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    GlobalScope.launch {
        delay(100)
        println("Background task: ${Thread.currentThread().name}")
    }
    runBlocking {
        println("Primary task: ${Thread.currentThread().name}")
        delay(200)
    }
}