package com.example.lab2.controller;

import com.example.lab2.model.Book;
import com.example.lab2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public Mono<ResponseEntity<Book>> create(@RequestBody Book book) {
        return service.createBook(book)
                .map(ResponseEntity::ok);
    }

    @GetMapping
    public Flux<Book> getAll() {
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Book>> getById(@PathVariable String id) {
        return service.getBookById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/available")
    public Flux<Book> getAvailable() {
        return service.getAvailableBooks();
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Book>> update(@PathVariable String id,
                                             @RequestBody Book book) {
        return service.updateBook(id, book)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
        return service.deleteBook(id)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }
}
