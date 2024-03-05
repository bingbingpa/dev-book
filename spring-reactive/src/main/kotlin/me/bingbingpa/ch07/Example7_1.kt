package me.bingbingpa.ch07

import me.bingbingpa.common.logger
import reactor.core.publisher.Flux

fun main() {
    val coldFlux = Flux
        .fromIterable(listOf("KOREA", "JAPAN", "CHINESE"))
        .map(String::lowercase)

    coldFlux.subscribe { country -> logger.info("# Subscriber1: $country") }
    println("--------------------------------------------------------------")
    Thread.sleep(2000L)
    coldFlux.subscribe { country -> logger.info("# Subscriber2: $country") }
}