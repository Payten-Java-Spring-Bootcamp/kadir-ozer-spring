package com.example.week2.service;

import com.example.week2.model.Member;
import com.example.week2.model.Movie;
import com.example.week2.model.WatchList;
import com.example.week2.request.MemberAddRequest;
import com.example.week2.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MemberService {

    private static final Integer DUMMY_SIZE = RandomUtils.random.nextInt(0,20);


    public Member add(MemberAddRequest request) {
        final var newMember = Member.MemberBuilder.aMember()
                .withBirthDate(request.getBirthDate())
                .withEmail(request.getEmail())
                .withName(request.getName())
                .build();

        log.info("New Member is created successfully Member:{}", newMember);
        return newMember;
    }

    public List<Member> getAll() {
        List<Member> memberList = new ArrayList<>();
        for (int i = 0; i < DUMMY_SIZE; i++) {
            memberList.add(Member.RandomMemberGenerator.generateMember());
        }
        return memberList;
    }

    public Member getById(Long memberId) {
        return Member.RandomMemberGenerator.generateMemberById(memberId);

    }

    public void deleteMemberById(Long memberId) {
        log.info("Member is deleted successfully. MemberId:{}",memberId);
    }

    public Member updateMemberById(Long memberId, MemberAddRequest request) {
        var member = Member.RandomMemberGenerator.generateMemberById(memberId);
        member.setBirthDate(request.getBirthDate());
        member.setEmail(request.getEmail());
        member.setName(request.getName());
        return member;
    }

    public Movie rateMovie(Long movieID, Integer point) {
        var movie = Movie.RandomMovieGenerator.generateMovieById(movieID);
        movie.setRating(point);
        return movie;
    }

    public Member createWatchList(Long memberId, String watchListName) {
        var member = Member.RandomMemberGenerator.generateMemberById(memberId);
        var watchList =  WatchList.WatchListBuilder.aWatchList().withName(watchListName).build();
        member.addToWatchLists(watchList);
        return member;
    }

    public WatchList addMovieToWatchList(Long watchListId, List<Long> movieIds) {
        var watchList = WatchList.RandomWatchListGenerator.generateWatchListById(watchListId);
        watchList.addMoviesToList(movieIds);
        return watchList;
    }
}
