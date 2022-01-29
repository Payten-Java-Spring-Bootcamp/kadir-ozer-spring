package com.example.week3.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class WatchListResponse {
    private Long id;
    private String name;
    private List<Long> movies;
}
