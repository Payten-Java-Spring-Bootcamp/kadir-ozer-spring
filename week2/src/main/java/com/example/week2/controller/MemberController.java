package com.example.week2.controller;

import com.example.week2.model.Member;
import com.example.week2.model.request.MemberAddRequest;
import com.example.week2.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Member addMember(@RequestBody MemberAddRequest request) {
        return memberService.add(request);
    }

    @GetMapping("/list-all")
    public List<Member> listMembers() {
        return memberService.getAll();
    }

    @GetMapping("/{memberId}/detail")
    public Member showMember(@PathVariable Long memberId) {
        return memberService.getById(memberId);
    }

    @PutMapping("/{memberId}/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Member updateMember(@PathVariable Long memberId, @RequestBody MemberAddRequest request) {
        return memberService.updateMemberById(memberId, request);
    }

    @DeleteMapping("/{memberId}/remove")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeMember(@PathVariable Long memberId)
    {
        memberService.deleteMemberById(memberId);
    }

}
