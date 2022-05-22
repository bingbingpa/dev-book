package ch13

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job = coroutineContext[Job.Key]!!

        launch { println("This is task A") }
        launch { println("This is task B") }

        println("${job.children.count()} children running")
    }
}