package ch13

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.System.currentTimeMillis

fun main() {
    val time = currentTimeMillis()

    GlobalScope.launch {
        delay(100)
        println("Task 1 finished in ${currentTimeMillis() - time} ms")
    }

    GlobalScope.launch {
        delay(100)
        println("Task 2 finished in ${currentTimeMillis() - time} ms")
    }

    Thread.sleep(200)
}