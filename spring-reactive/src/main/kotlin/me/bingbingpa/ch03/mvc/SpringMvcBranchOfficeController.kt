package me.bingbingpa.ch03.mvc

import me.bingbingpa.ch03.domain.Book
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/v1/books")
class SpringMvcBranchOfficeController(private val bookMap: Map<Long, Book>) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{book-id}")
    @Throws(InterruptedException::class)
    fun getBook(@PathVariable("book-id") bookId: Long): ResponseEntity<Book> {
        // 테스트를 위해 5초 딜레이
        Thread.sleep(5000)

        val book: Book? = bookMap[bookId]

        return ResponseEntity.ok(book)
    }
}