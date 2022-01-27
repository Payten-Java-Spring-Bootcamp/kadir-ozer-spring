package com.example.week3.model;

import com.example.week3.model.entity.MovieEntity;
import com.example.week3.model.entity.RateEntity;
import com.example.week3.model.enums.Genre;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class Movie {

    private Long id;
    private String name;
    private Genre genre;
    private String director;
    private List<String> cast;
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
                .overallRating(movieEntity.getRates().stream()
                        .mapToDouble(RateEntity::getPoint)
                        .average()
                        .orElse(0))
                .build();
    }
}
