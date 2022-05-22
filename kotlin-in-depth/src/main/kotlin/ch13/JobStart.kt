package ch13

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job = launch(start = CoroutineStart.LAZY) {
            println("Job started")
        }

        delay(100)

        println("Preparing to start ...")
        job.start()
    }
}