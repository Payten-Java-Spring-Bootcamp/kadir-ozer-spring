package com.example.week3.model.request;

import com.example.week3.model.Movie;
import com.example.week3.model.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class MovieAddRequest {
    @NotBlank
    private String name;

    @NotBlank
    private Genre genre;

    @NotNull
    private Integer releaseYear;

    @NotBlank
    private String directorName;

    private Set<String> cast;

    public Movie convert() {
        return Movie.builder()
                .name(getName())
                .cast(getCast())
                .genre(getGenre())
                .director(getDirectorName())
                .releaseYear(getReleaseYear())
                .build();
    }
}
