package com.example.week3.service;

import com.example.week3.model.Member;
import com.example.week3.model.entity.MemberEntity;
import com.example.week3.model.request.MemberAddRequest;
import com.example.week3.model.response.MemberResponse;
import com.example.week3.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Member add(Member member) {
        final var newEntity = memberRepository.save(Member.convertToEntity(member));

        log.info("New Member is created successfully Member:{}", newEntity);
        return Member.convertFromEntity(newEntity);
    }

    public List<Member> getAll() {
        List<MemberEntity> memberList = memberRepository.findAll();
        return memberList.stream().map(Member::convertFromEntity).collect(Collectors.toList());
    }

    public Member getById(Long memberId) {
        final var member = memberRepository.getById(memberId);

        return Member.convertFromEntity(member);
    }

    public void deleteMemberById(Long memberId) {
        log.info("Member is deleted successfully. MemberId:{}",memberId);
    }

    public MemberResponse updateMemberById(Long memberId, MemberAddRequest request) {
        return null;
    }

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
}
