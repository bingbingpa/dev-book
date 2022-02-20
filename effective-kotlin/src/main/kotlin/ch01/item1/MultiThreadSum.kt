package ch01.item1

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

fun useThread() {
    var num = 0
    for (i in 1..1000) {
        thread {
            Thread.sleep(10)
            num += 1
        }
    }
    Thread.sleep(5000)
    println(num) //1000 이 아닐 확률이 매우 높다.
}

suspend fun useCoroutine() {
    var num = 0
    coroutineScope {
        for (i in 1..1000) {
            launch {
                delay(10)
                num+=1
            }
        }
    }
    println(num)
}

fun syncThread() {
    val lock = Any()
    var num = 0
    for (i in 1..1000) {
        thread {
            Thread.sleep(10)
            synchronized(lock) { num += 1}
        }
    }
    Thread.sleep(1000)
    println(num) //1000
}

suspend fun main() {
    useThread()
    useCoroutine()
    syncThread()
}