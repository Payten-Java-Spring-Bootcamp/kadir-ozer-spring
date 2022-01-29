package com.example.week3.model.response;

import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class WatchListResponse {
    private Long id;
    private String name;
    private Long memberId;
    private Set<MovieResponse> movies;
}
