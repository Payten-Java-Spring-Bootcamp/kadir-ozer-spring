package com.example.week2.model;

import com.example.week2.model.enums.Genre;
import com.example.week2.model.util.RandomUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Random;

@Getter
@Setter
@ToString
public class Movie {

    private Long id;
    private String name;
    private Genre genre;
    private Integer releaseYear;
    private String directorName;
    private List<String> cast;
    private static final Random random = new Random();

    public Movie() {
        this.id = random.nextLong();
    }

    public static final class MovieBuilder {
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

        public Movie build() {
            Movie movie = new Movie();
            movie.setName(name);
            movie.setGenre(genre);
            movie.setReleaseYear(releaseYear);
            movie.setDirectorName(directorName);
            movie.setCast(cast);
            return movie;
        }
    }

    public static final class RandomMovieGenerator {

        public Movie generateMovieById(Long movieId) {
            return MovieBuilder.aMovie()
                    .withName("movie-" + movieId)
                    .withGenre(RandomUtils.randomEnum(Genre.class))
                    .withDirectorName("director-" + movieId)
                    .withCast(List.of())
                    .withReleaseYear(RandomUtils.randomYear())
                    .build();
        }
    }
}
