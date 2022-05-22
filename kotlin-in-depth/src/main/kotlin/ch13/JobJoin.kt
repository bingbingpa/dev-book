package ch13

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job = coroutineContext[Job.Key]!!
        val jobA = launch { println("This is task A") }
        val jobB = launch { println("This is task B") }

        jobA.join()
        jobB.join()

        println("${job.children.count()} children running")
    }
}