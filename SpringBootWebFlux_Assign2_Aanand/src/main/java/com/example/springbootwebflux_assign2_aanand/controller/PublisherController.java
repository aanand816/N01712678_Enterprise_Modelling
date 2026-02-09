package com.example.springbootwebflux_assign2_aanand.controller;

import com.example.springbootwebflux_assign2_aanand.model.Publisher;
import com.example.springbootwebflux_assign2_aanand.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/publishers")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Publisher> createPublisher(@RequestBody Publisher publisher) {
        return publisherService.createPublisher(publisher);
    }

    @GetMapping
    public Flux<Publisher> getAllPublishers() {
        return publisherService.getAllPublishers();
    }

    @GetMapping("/{id}")
    public Mono<Publisher> getPublisherById(@PathVariable String id) {
        return publisherService.getPublisherById(id);
    }

    @PutMapping("/{id}")
    public Mono<Publisher> updatePublisher(@PathVariable String id,
                                           @RequestBody Publisher publisher) {
        return publisherService.updatePublisher(id, publisher);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deletePublisher(@PathVariable String id) {
        return publisherService.deletePublisher(id);
    }

    // Get count of books for a publisher
    @GetMapping("/{id}/book-count")
    public Mono<Long> getBookCountByPublisher(@PathVariable String id) {
        return publisherService.getBookCountByPublisher(id);
    }
}
