package me.bingbingpa.ch03.mvc

import me.bingbingpa.ch03.domain.Book
import me.bingbingpa.common.lazyLogger
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.time.LocalTime


@SpringBootApplication
class SpringMvcBranchOfficeApplication {
    @Bean
    fun bookMap(): Map<Long, Book> {
        val bookMap: MutableMap<Long, Book> = HashMap()
        for (i in 1L..2000000L) {
            bookMap[i] = Book(i, "IT Book$i", 2000)
        }

        return bookMap
    }

    @Bean
    fun restTemplate(): RestTemplateBuilder {
        return RestTemplateBuilder()
    }

    @Bean
    fun run() = CommandLineRunner {
        logger.info("# 요청 시작 시간: {}", LocalTime.now())
        for (i in 1..5) {
            val book = this.getBook(i.toLong())
            logger.info("{}: book name: {}", LocalTime.now(), book?.name)
        }
    }

    private fun getBook(bookId: Long): Book? {
        val restTemplate = RestTemplate()
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

        val response =
            restTemplate.getForEntity(getBooksUri, Book::class.java)
        val book = response.body

        return book
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SpringMvcBranchOfficeApplication::class.java, *args)
        }
        private val logger by lazyLogger()
    }
}
