package me.bingbingpa.ch07

import com.jayway.jsonpath.JsonPath
import me.bingbingpa.common.logger
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono
import java.net.URI


fun main() {
    val worldTimeUri = UriComponentsBuilder.newInstance().scheme("http")
        .host("worldtimeapi.org")
        .port(80)
        .path("/api/timezone/Asia/Seoul")
        .build()
        .encode()
        .toUri()

    val mono = getWorldTime(worldTimeUri)
//        .cache()
    mono.subscribe { dateTime -> logger.info("# dateTime 1: $dateTime") }
    Thread.sleep(2000L)
    mono.subscribe { dateTime -> logger.info("# dateTime 2: $dateTime") }

    Thread.sleep(2000L)
}

private fun getWorldTime(worldTimeUri: URI): Mono<String> {
    return WebClient.create()
        .get()
        .uri(worldTimeUri)
        .retrieve()
        .bodyToMono(String::class.java)
        .map { response ->
            val jsonContext = JsonPath.parse(response)
            jsonContext.read("$.datetime")
        }
}
