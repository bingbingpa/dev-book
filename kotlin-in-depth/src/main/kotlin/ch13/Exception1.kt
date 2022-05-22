package ch13

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught $exception")
    }

    GlobalScope.launch(handler) {
        launch {
            throw Exception("Error in task A")
            println("Task A completed")
        }

        launch {
            delay(1000)
            println("Task B completed")
        }

        println("Root")
    }.join()
}