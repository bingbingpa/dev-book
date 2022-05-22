package ch13

import kotlinx.coroutines.delay

suspend fun foo() {
    println("task started")
    delay(1000)
    println("Task finished")
}

suspend fun main() {
    foo()
}