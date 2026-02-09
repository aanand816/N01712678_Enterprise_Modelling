package com.example.lab2.service;

import com.example.lab2.model.Book;
import com.example.lab2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Mono<Book> createBook(Book book) {
        return repository.save(book);
    }

    public Flux<Book> getAllBooks() {
        return repository.findAll();
    }

    public Mono<Book> getBookById(String id) {
        return repository.findById(id);
    }

    public Flux<Book> getAvailableBooks() {
        return repository.findByAvailable(true);
    }

    public Mono<Book> updateBook(String id, Book updated) {
        return repository.findById(id)
                .flatMap(existing -> {
                    existing.setTitle(updated.getTitle());
                    existing.setAuthor(updated.getAuthor());
                    existing.setPrice(updated.getPrice());
                    existing.setAvailable(updated.isAvailable());
                    existing.setPubId(updated.getPubId());
                    return repository.save(existing);
                });
    }

    public Mono<Void> deleteBook(String id) {
        return repository.deleteById(id);
    }
}
