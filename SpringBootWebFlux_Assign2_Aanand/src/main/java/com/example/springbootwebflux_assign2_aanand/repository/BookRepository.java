package com.example.springbootwebflux_assign2_aanand.repository;

import com.example.springbootwebflux_assign2_aanand.model.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BookRepository extends ReactiveMongoRepository<Book, String> {

    Flux<Book> findByPublisherId(String publisherId);
    Flux<Book> findByMemberId(String memberId);
    Flux<Book> findByAvailable(Boolean available);
}
