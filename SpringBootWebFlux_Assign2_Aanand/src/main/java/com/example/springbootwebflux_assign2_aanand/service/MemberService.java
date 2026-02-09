package com.example.springbootwebflux_assign2_aanand.service;

import com.example.springbootwebflux_assign2_aanand.model.Member;
import com.example.springbootwebflux_assign2_aanand.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Mono<Member> createMember(Member member) {
        return memberRepository.save(member);
    }

    public Flux<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Mono<Member> getMemberById(String id) {
        return memberRepository.findById(id);
    }

    public Mono<Member> updateMember(String id, Member updated) {
        return memberRepository.findById(id)
                .flatMap(existing -> {
                    existing.setName(updated.getName());
                    existing.setAddress(updated.getAddress());
                    existing.setMembType(updated.getMembType());
                    existing.setMembDate(updated.getMembDate());
                    existing.setExpiryDate(updated.getExpiryDate());
                    return memberRepository.save(existing);
                });
    }

    public Mono<Void> deleteMember(String id) {
        return memberRepository.deleteById(id);
    }
}
