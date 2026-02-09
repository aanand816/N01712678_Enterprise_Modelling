package com.example.springbootwebflux_assign2_aanand.controller;

import com.example.springbootwebflux_assign2_aanand.model.Member;
import com.example.springbootwebflux_assign2_aanand.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Member> createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @GetMapping
    public Flux<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Mono<Member> getMemberById(@PathVariable String id) {
        return memberService.getMemberById(id);
    }

    @PutMapping("/{id}")
    public Mono<Member> updateMember(@PathVariable String id,
                                     @RequestBody Member member) {
        return memberService.updateMember(id, member);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteMember(@PathVariable String id) {
        return memberService.deleteMember(id);
    }
}
