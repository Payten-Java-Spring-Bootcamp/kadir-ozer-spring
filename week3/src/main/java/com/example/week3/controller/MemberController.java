//package com.example.week3.controller;
//
//import com.example.week3.model.response.MemberResponse;
//import com.example.week3.model.response.MovieResponse;
//import com.example.week3.model.response.WatchListResponse;
//import com.example.week3.model.request.MemberAddRequest;
//import com.example.week3.service.MemberService;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/member")
//public class MemberController {
//
//    private final MemberService memberService;
//
//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }
//
//    @PostMapping("/add")
//    @ResponseStatus(HttpStatus.CREATED)
//    public MemberResponse addMember(@RequestBody MemberAddRequest request) {
//        return memberService.add(request);
//    }
//
//    @GetMapping("/list-all")
//    public List<MemberResponse> listMembers() {
//        return memberService.getAll();
//    }
//
//    @GetMapping("/{memberId}/detail")
//    public MemberResponse showMember(@PathVariable Long memberId) {
//        return memberService.getById(memberId);
//    }
//
//    @PutMapping("/{memberId}/update")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public MemberResponse updateMember(@PathVariable Long memberId, @RequestBody MemberAddRequest request) {
//        return memberService.updateMemberById(memberId, request);
//    }
//
//    @DeleteMapping("/{memberId}/remove")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void removeMember(@PathVariable Long memberId) {
//        memberService.deleteMemberById(memberId);
//    }
//
//    @PostMapping("/{memberId}/rate_movie")
//    public MovieResponse rateMovie(@PathVariable Long memberId, @RequestParam Long movieID, @RequestParam Integer point) {
//        return memberService.rateMovie(movieID,point);
//    }
//
//    @PostMapping("/{memberId}/watchlist/add")
//    @ResponseStatus(HttpStatus.CREATED)
//    public MemberResponse createWatchList(@PathVariable Long memberId, @RequestParam String watchListName) {
//        return memberService.createWatchList(memberId,watchListName);
//    }
//
//    @PutMapping("/{watchListId}/addMovie")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public WatchListResponse addMovieToWatchList(@PathVariable Long watchListId, @RequestParam List<Long> movieIds) {
//        return memberService.addMovieToWatchList(watchListId,movieIds);
//    }
//
//
//}
