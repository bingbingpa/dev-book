package me.bingbingpa.ch05

import reactor.core.publisher.Flux
import java.util.*

fun main() {
    Flux.just("Hello", "Reactor")
        .map { it.lowercase(Locale.getDefault()) }
        .subscribe(::println)
}