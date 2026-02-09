package com.example.springbootwebflux_assign2_aanand.service;

import com.example.springbootwebflux_assign2_aanand.model.Publisher;
import com.example.springbootwebflux_assign2_aanand.repository.BookRepository;
import com.example.springbootwebflux_assign2_aanand.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final BookRepository bookRepository;

    public Mono<Publisher> createPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public Flux<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public Mono<Publisher> getPublisherById(String id) {
        return publisherRepository.findById(id);
    }

    public Mono<Publisher> updatePublisher(String id, Publisher updated) {
        return publisherRepository.findById(id)
                .flatMap(existing -> {
                    existing.setName(updated.getName());
                    existing.setAddress(updated.getAddress());
                    return publisherRepository.save(existing);
                });
    }

    public Mono<Void> deletePublisher(String id) {
        return publisherRepository.deleteById(id);
    }

    // Get count of books for a publisher
    public Mono<Long> getBookCountByPublisher(String publisherId) {
        return bookRepository.findByPublisherId(publisherId).count();
    }
}
