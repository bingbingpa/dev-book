package ch13

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun CoroutineScope.showName() {
    println("Current coroutine: ${coroutineContext[CoroutineName]?.name}")
}

fun main() {
    runBlocking {
        showName()
        launch(coroutineContext + CoroutineName("Worker")) {
            showName()
        }
    }
}