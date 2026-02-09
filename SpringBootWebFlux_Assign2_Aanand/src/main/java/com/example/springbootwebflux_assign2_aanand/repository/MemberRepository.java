package com.example.springbootwebflux_assign2_aanand.repository;

import com.example.springbootwebflux_assign2_aanand.model.Member;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends ReactiveMongoRepository<Member, String> {
}
