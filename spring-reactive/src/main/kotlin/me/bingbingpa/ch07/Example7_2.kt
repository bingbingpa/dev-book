package me.bingbingpa.ch07

import me.bingbingpa.common.logger
import reactor.core.publisher.Flux
import java.time.Duration

fun main() {
    val singers = arrayOf("Singer A", "Singer B", "Singer C", "Singer D", "Singer E")
    logger.info("# Begin concert:")
    val concertFlux = Flux
        .fromArray(singers)
        .delayElements(Duration.ofSeconds(1)) // 데이터 소스로 입력된 각 데이터의 emit 을 일정시간 동안 지연시키는 오퍼레이터
        .share() // cold sequence 를 hot sequence 로 동작하게 해주는 오퍼레이터

    concertFlux.subscribe { singer -> logger.info("# Subscriber1 is watching ${singer}'s song") }

    Thread.sleep(2500L)

    concertFlux.subscribe { singer -> logger.info("# Subscriber2 is watching ${singer}'s song") }

    Thread.sleep(3000L)
}