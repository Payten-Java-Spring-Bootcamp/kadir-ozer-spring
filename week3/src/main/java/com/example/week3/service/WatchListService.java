package com.example.week3.service;

import com.example.week3.model.WatchList;
import com.example.week3.repository.WatchListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WatchListService {

    private final WatchListRepository watchListRepository;
    private final MovieService movieService;
    private final MemberService memberService;

    public WatchListService(WatchListRepository watchListRepository, MovieService movieService, MemberService memberService) {
        this.watchListRepository = watchListRepository;
        this.movieService = movieService;
        this.memberService = memberService;
    }

    public WatchList add(WatchList watchList) {
        final var movieEntities = movieService.findAllMoviesByIdList(watchList.getMovieIdList());
        final var memberEntity = memberService.getEntityById(watchList.getMemberId());
        final var newEntity = watchListRepository.save(WatchList.convertToEntity(watchList,memberEntity,movieEntities));
        return WatchList.convertFromEntity(newEntity);
    }

    public Set<WatchList> getAll(){
        final var watchListEntities = watchListRepository.findAll();
        return watchListEntities.stream().map(WatchList::convertFromEntity).collect(Collectors.toSet());
    }
}
