package com.example.week3.controller;

import com.example.week3.model.Member;
import com.example.week3.model.request.MemberAddRequest;
import com.example.week3.model.response.MemberResponse;
import com.example.week3.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberResponse addMember(@RequestBody @Valid MemberAddRequest request) {
        final var newMember = memberService.add(request.convert());

        return newMember.toResponse();
    }

    @GetMapping("/list-all")
    public List<MemberResponse> listMembers() {
        return memberService.getAll().stream().map(Member::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{memberId}/detail")
    public MemberResponse showMember(@PathVariable Long memberId) {
        return memberService.getById(memberId).toResponse();
    }

    @PutMapping("/{memberId}/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MemberResponse updateMember(@PathVariable Long memberId, @RequestBody MemberAddRequest request) {
        return memberService.updateMemberById(memberId, request);
    }

    @DeleteMapping("/{memberId}/remove")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeMember(@PathVariable Long memberId) {
        memberService.deleteMemberById(memberId);
    }
}
