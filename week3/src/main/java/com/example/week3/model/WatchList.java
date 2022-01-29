package com.example.week3.model;

import com.example.week3.model.entity.MemberEntity;
import com.example.week3.model.entity.MovieEntity;
import com.example.week3.model.entity.WatchListEntity;
import com.example.week3.model.response.WatchListResponse;
import lombok.*;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WatchList {

    private Long id;
    private String name;
    private Long memberId;
    private Set<Long> movieIdList;
    private Set<Movie> movieList;


    public static WatchListEntity convertToEntity(WatchList watchList, MemberEntity memberEntity, Set<MovieEntity> movieEntities){
        return WatchListEntity.builder()
                .id(watchList.getId())
                .name(watchList.getName())
                .member(memberEntity)
                .movieList(movieEntities)
                .build();
    }

    public static WatchList convertFromEntity(WatchListEntity watchListEntity){
        return builder()
                .id(watchListEntity.getId())
                .name(watchListEntity.getName())
                .memberId(watchListEntity.getMember().getId())
                .movieList(watchListEntity.getMovieList()
                        .stream()
                        .map(Movie::convertFromEntity)
                        .collect(Collectors.toSet()))
                .build();
    }

    public WatchListResponse toResponse() {
        return WatchListResponse.builder()
                .id(getId())
                .name(getName())
                .memberId(getMemberId())
                .movies(getMovieList().stream().map(Movie::toResponse).collect(Collectors.toSet()))
                .build();
    }
}
