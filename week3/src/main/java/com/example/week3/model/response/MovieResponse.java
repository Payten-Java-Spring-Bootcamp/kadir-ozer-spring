package com.example.week3.model.response;

import com.example.week3.model.enums.Genre;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponse {

    private Long id;
    private String name;
    private Genre genre;
    private Integer releaseYear;
    private String directorName;
    private Set<String> cast;
    private Double overallRating;
}
