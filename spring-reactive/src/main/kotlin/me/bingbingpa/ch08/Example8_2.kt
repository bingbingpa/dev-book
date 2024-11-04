package me.bingbingpa.ch08

import me.bingbingpa.common.logger
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import java.time.Duration

fun main() {
    Flux
        .interval(Duration.ofMillis(1L))
        .onBackpressureError()
        .doOnNext { data -> logger.info("$ doOnNext: $data") }
        .publishOn(Schedulers.parallel())
        .subscribe(
            { data: Long? ->
                try {
                    Thread.sleep(5L)
                } catch (e: InterruptedException) {
                    logger.info("interrupted")
                }
                logger.info("# onNext: $data")
            },
            { error: Throwable? -> logger.error("# onError = $error") })
    Thread.sleep(2000L)
}