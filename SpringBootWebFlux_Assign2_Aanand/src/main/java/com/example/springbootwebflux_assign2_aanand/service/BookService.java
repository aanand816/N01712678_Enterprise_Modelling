package com.example.springbootwebflux_assign2_aanand.service;

import com.example.springbootwebflux_assign2_aanand.model.Book;
import com.example.springbootwebflux_assign2_aanand.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    // Basic CRUD
    public Mono<Book> createBook(Book book) {
        book.setAvailable(true);
        book.setIssue("NOT_ISSUED");
        return bookRepository.save(book);
    }

    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Mono<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    public Mono<Book> updateBook(String id, Book updatedBook) {
        return bookRepository.findById(id)
                .flatMap(existingBook -> {
                    existingBook.setTitle(updatedBook.getTitle());
                    existingBook.setAuthor(updatedBook.getAuthor());
                    existingBook.setPrice(updatedBook.getPrice());
                    existingBook.setPublisherId(updatedBook.getPublisherId());
                    return bookRepository.save(existingBook);
                });
    }

    public Mono<Void> deleteBook(String id) {
        return bookRepository.deleteById(id);
    }

    // Get all books by a publisher
    public Flux<Book> getBooksByPublisher(String publisherId) {
        return bookRepository.findByPublisherId(publisherId);
    }

    // Get all available books
    public Flux<Book> getAvailableBooks() {
        return bookRepository.findByAvailable(true);
    }

    // Get all books issued to a member
    public Flux<Book> getBooksIssuedToMember(String memberId) {
        return bookRepository.findByMemberId(memberId);
    }

    // Issue a book to a member
    public Mono<Book> issueBook(String bookId, String memberId) {
        return bookRepository.findById(bookId)
                .flatMap(book -> {
                    if (!book.getAvailable()) {
                        return Mono.error(new RuntimeException("Book is already issued"));
                    }
                    book.setAvailable(false);
                    book.setIssue("ISSUED");
                    book.setMemberId(memberId);
                    book.setDueDate(LocalDate.now().plusDays(14).toString()); // 14 days from now
                    book.setReturnDate(null);
                    return bookRepository.save(book);
                });
    }

    // Return a book
    public Mono<Book> returnBook(String bookId) {
        return bookRepository.findById(bookId)
                .flatMap(book -> {
                    if (book.getAvailable()) {
                        return Mono.error(new RuntimeException("Book is not currently issued"));
                    }
                    book.setAvailable(true);
                    book.setIssue("NOT_ISSUED");
                    book.setReturnDate(LocalDate.now().toString());
                    book.setMemberId(null);
                    book.setDueDate(null);
                    return bookRepository.save(book);
                });
    }
}
