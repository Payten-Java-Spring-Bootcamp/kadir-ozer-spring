package com.example.week3.model.response;

import com.example.week3.model.enums.Genre;
import com.example.week3.util.RandomUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class MovieResponse {

    private Long id;
    private String name;
    private Genre genre;
    private Integer releaseYear;
    private String directorName;
    private List<String> cast;

    public MovieResponse() {
        this.id = RandomUtils.randomLong();
    }

    public static final class MovieBuilder {
        private Long id;
        private String name;
        private Genre genre;
        private Integer releaseYear;
        private String directorName;
        private List<String> cast;

        private MovieBuilder() {
        }

        public static MovieBuilder aMovie() {
            return new MovieBuilder();
        }

        public MovieBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public MovieBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public MovieBuilder withGenre(Genre genre) {
            this.genre = genre;
            return this;
        }

        public MovieBuilder withReleaseYear(Integer releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        public MovieBuilder withDirectorName(String directorName) {
            this.directorName = directorName;
            return this;
        }

        public MovieBuilder withCast(List<String> cast) {
            this.cast = cast;
            return this;
        }

        public MovieResponse build() {
            MovieResponse movie = new MovieResponse();
            movie.setId(id);
            movie.setName(name);
            movie.setGenre(genre);
            movie.setReleaseYear(releaseYear);
            movie.setDirectorName(directorName);
            movie.setCast(cast);
            return movie;
        }
    }
}
