package com.example.week3.model;

import com.example.week3.model.entity.MovieEntity;
import com.example.week3.model.entity.RateEntity;
import com.example.week3.model.enums.Genre;
import com.example.week3.model.response.MovieResponse;
import lombok.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    private Long id;
    private String name;
    private Genre genre;
    private String director;
    private Set<String> cast;
    private Integer releaseYear;
    private Double overallRating;

    public static MovieEntity convertToEntity(Movie movie) {
        return MovieEntity.builder()
                .id(movie.getId())
                .name(movie.getName())
                .genre(movie.getGenre())
                .director(movie.getDirector())
                .cast(movie.getCast())
                .releaseYear(movie.getReleaseYear())
                .build();
    }

    public static Movie convertFromEntity(MovieEntity movieEntity) {
        return builder()
                .id(movieEntity.getId())
                .name(movieEntity.getName())
                .genre(movieEntity.getGenre())
                .director(movieEntity.getDirector())
                .cast(movieEntity.getCast())
                .releaseYear(movieEntity.getReleaseYear())
                .overallRating(Optional.ofNullable(movieEntity.getRates())
                        .orElseGet(Collections::emptySet).stream()
                        .mapToDouble(RateEntity::getPoint)
                        .average()
                        .orElse(0))
                .build();
    }

    public MovieResponse toResponse() {
        return MovieResponse.builder()
                .id(getId())
                .name(getName())
                .genre(getGenre())
                .directorName(getDirector())
                .cast(getCast())
                .releaseYear(getReleaseYear())
                .overallRating(getOverallRating())
                .build();
    }
}
