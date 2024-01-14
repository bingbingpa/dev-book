package me.bingbingpa.ch03.reactive

import me.bingbingpa.ch03.domain.Book
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono


@RequestMapping("/v1/books")
@RestController
class SpringReactiveBranchOfficeController(private val bookMap: Map<Long, Book>) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{book-id}")
    @Throws(InterruptedException::class)
    fun getBook(@PathVariable("book-id") bookId: Long): Mono<Book> {
        Thread.sleep(5000)

        val book: Book = bookMap[bookId] ?: throw RuntimeException("not found bookId = $bookId")

        return Mono.just(book)
    }
}