package com.example.week3.model;

import com.example.week3.model.entity.MovieEntity;
import com.example.week3.model.entity.WatchListEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class WatchList {

    private Long id;
    private String name;
    private Set<Movie> movieList;


    public static WatchListEntity convertToEntity(WatchList watchList){
        return WatchListEntity.builder()
                .id(watchList.getId())
                .name(watchList.getName())
                .movieList(watchList.getMovieList()
                        .stream()
                        .map(Movie::convertToEntity)
                        .collect(Collectors.toSet()))
                .build();
    }

    public static WatchList convertFromEntity(WatchListEntity watchListEntity){
        return builder()
                .id(watchListEntity.getId())
                .name(watchListEntity.getName())
                .movieList(watchListEntity.getMovieList()
                        .stream()
                        .map(Movie::convertFromEntity)
                        .collect(Collectors.toSet()))
                .build();
    }
}
