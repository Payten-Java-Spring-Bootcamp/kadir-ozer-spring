//package com.example.week3.service;
//
//import com.example.week3.model.response.MemberResponse;
//import com.example.week3.model.response.MovieResponse;
//import com.example.week3.model.response.WatchListResponse;
//import com.example.week3.model.request.MemberAddRequest;
//import com.example.week3.util.ObjectGenerator;
//import com.example.week3.util.RandomUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Slf4j
//@Service
//public class MemberService {
//
//    private static final Integer DUMMY_SIZE = RandomUtils.random.nextInt(20);
//
//
//    public MemberResponse add(MemberAddRequest request) {
//        final var newMember = MemberResponse.MemberBuilder.aMember()
//                .withBirthDate(request.getBirthDate())
//                .withEmail(request.getEmail())
//                .withName(request.getName())
//                .build();
//
//        log.info("New Member is created successfully Member:{}", newMember);
//        return newMember;
//    }
//
//    public List<MemberResponse> getAll() {
//        List<MemberResponse> memberList = new ArrayList<>();
//        for (int i = 0; i < DUMMY_SIZE; i++) {
//            memberList.add(ObjectGenerator.RandomMemberGenerator.generateMember());
//        }
//        return memberList;
//    }
//
//    public MemberResponse getById(Long memberId) {
//        return ObjectGenerator.RandomMemberGenerator.generateMemberById(memberId);
//
//    }
//
//    public void deleteMemberById(Long memberId) {
//        log.info("Member is deleted successfully. MemberId:{}",memberId);
//    }
//
//    public MemberResponse updateMemberById(Long memberId, MemberAddRequest request) {
//        var member = ObjectGenerator.RandomMemberGenerator.generateMemberById(memberId);
//        member.setBirthDate(request.getBirthDate());
//        member.setEmail(request.getEmail());
//        member.setName(request.getName());
//        return member;
//    }
//
//    public MovieResponse rateMovie(Long movieID, Integer point) {
//        var movie = ObjectGenerator.RandomMovieGenerator.generateMovieById(movieID);
//        movie.setRating(point);
//        return movie;
//    }
//
//    public MemberResponse createWatchList(Long memberId, String watchListName) {
//        var member = ObjectGenerator.RandomMemberGenerator.generateMemberById(memberId);
//        var watchList =  WatchListResponse.WatchListBuilder.aWatchList().withName(watchListName).build();
//        member.addToWatchLists(watchList);
//        return member;
//    }
//
//    public WatchListResponse addMovieToWatchList(Long watchListId, List<Long> movieIds) {
//        var watchList = ObjectGenerator.RandomWatchListGenerator.generateWatchListById(watchListId);
//        watchList.addMoviesToList(movieIds);
//        return watchList;
//    }
//}
