package me.bingbingpa.ch08

import me.bingbingpa.common.logger
import org.reactivestreams.Subscription
import reactor.core.publisher.BaseSubscriber
import reactor.core.publisher.Flux

fun main() {
    Flux.range(1, 5)
        .doOnRequest { data -> logger.info("# doOnRequest: $data") }
        .subscribe(object : BaseSubscriber<Int>() {
            override fun hookOnSubscribe(subscription: Subscription) {
                request(1)
            }

            override fun hookOnNext(value: Int) {
                // Pubisher 의 데이터 emit 속도보다 Subscriber 의 데이터 처리 속도가 더 느린 것을 시뮬레이션하기 위해 2초의 지연 시간 추가
                Thread.sleep(2000L)
                logger.info("# hookOnNext: $value")
                request(1)
            }
        })
}