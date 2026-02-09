package com.example.springbootwebflux_assign2_aanand.repository;

import com.example.springbootwebflux_assign2_aanand.model.Publisher;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends ReactiveMongoRepository<Publisher, String> {
}
