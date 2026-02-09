package com.example.springbootwebflux_assign2_aanand.controller;

import com.example.springbootwebflux_assign2_aanand.model.Book;
import com.example.springbootwebflux_assign2_aanand.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // Basic CRUD
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Book> createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping
    public Flux<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Mono<Book> getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public Mono<Book> updateBook(@PathVariable String id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteBook(@PathVariable String id) {
        return bookService.deleteBook(id);
    }

    @GetMapping("/publisher/{publisherId}")
    public Flux<Book> getBooksByPublisher(@PathVariable String publisherId) {
        return bookService.getBooksByPublisher(publisherId);
    }

    // Get available books
    @GetMapping("/available")
    public Flux<Book> getAvailableBooks() {
        return bookService.getAvailableBooks();
    }

    // Get books issued to a member
    @GetMapping("/member/{memberId}")
    public Flux<Book> getBooksIssuedToMember(@PathVariable String memberId) {
        return bookService.getBooksIssuedToMember(memberId);
    }

    // Issue a book to a member
    @PostMapping("/{bookId}/issue/{memberId}")
    public Mono<Book> issueBook(@PathVariable String bookId, @PathVariable String memberId) {
        return bookService.issueBook(bookId, memberId);
    }

    // Return a book
    @PostMapping("/{bookId}/return")
    public Mono<Book> returnBook(@PathVariable String bookId) {
        return bookService.returnBook(bookId);
    }
}
