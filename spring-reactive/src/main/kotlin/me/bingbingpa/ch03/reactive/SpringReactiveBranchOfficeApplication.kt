package me.bingbingpa.ch03.reactive

import io.netty.util.NettyRuntime
import io.netty.util.internal.SystemPropertyUtil
import me.bingbingpa.ch03.domain.Book
import me.bingbingpa.common.lazyLogger
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono
import java.time.LocalTime
import java.util.function.Consumer
import java.util.stream.Collectors
import kotlin.math.max


@SpringBootApplication
class SpringReactiveBranchOfficeApplication {

    @Bean
    fun bookMap(): Map<Long, Book> {
        val bookMap: MutableMap<Long, Book> = HashMap()
        for (i in 1L..2000000L) {
            bookMap[i] = Book(i, "IT Book$i", 2000)
        }

        return bookMap
    }

    @Bean
    fun init(): CommandLineRunner {
        return CommandLineRunner {
            logger.info("CPU from Netty: " + NettyRuntime.availableProcessors())
            logger.info("CPU from JVM: " + Runtime.getRuntime().availableProcessors())
            logger.info("DEFAULT_EVENT_LOOP_THREADS: $DEFAULT_EVENT_LOOP_THREADS")
            Thread.getAllStackTraces().keys.stream()
                .collect(Collectors.toList())
                .forEach(
                    Consumer { thread: Thread ->
                        logger.info("-------------------------------------")
                        logger.info("thread name: " + thread.name)
                        logger.info("thread group: " + thread.threadGroup.name)
                        logger.info("thread ID: " + thread.id)
                        logger.info("thread state: " + thread.state)
                        logger.info("thread priority: " + thread.priority)
                        logger.info("is daemon: " + thread.isDaemon)
                        logger.info("-------------------------------------")
                    }
                )
        }
    }

    @Bean
    fun run() = CommandLineRunner {
        logger.info("# 요청 시작 시간: {}", LocalTime.now())
        for (i in 1..5) {
            getBook(i.toLong()).subscribe { book ->
                logger.info("{}: book name: {}", LocalTime.now(), book.name)
            }
        }
    }

    private fun getBook(bookId: Long): Mono<Book> {
        val baseUri = UriComponentsBuilder.newInstance().scheme("http")
            .host("localhost")
            .port(8080)
            .path("/v1/books")
            .build()
            .encode()
            .toUri()
        val getBooksUri = UriComponentsBuilder.fromUri(baseUri)
            .path("/{book-id}")
            .build()
            .expand(bookId)
            .encode()
            .toUri() // http://localhost:8080/v1/books/{book-id}

        return WebClient.create()
            .get()
            .uri(getBooksUri)
            .retrieve()
            .bodyToMono(Book::class.java)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SpringReactiveBranchOfficeApplication::class.java, *args)
        }
        private val logger by lazyLogger()
        val DEFAULT_EVENT_LOOP_THREADS = max(
            1.0, SystemPropertyUtil.getInt(
                "io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2
            ).toDouble()).toInt()
    }
}
