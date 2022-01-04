package com.example.week2.model;

import com.example.week2.model.enums.Genre;
import com.example.week2.model.util.RandomUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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
    private Integer rating = 0;

    public Movie() {
        this.id = RandomUtils.randomLong();
    }

    public static final class RandomMovieGenerator {

        public static Movie generateMovieById(Long movieId) {
            return MovieBuilder.aMovie()
                    .withId(movieId)
                    .withName("movie-" + movieId)
                    .withGenre(RandomUtils.randomEnum(Genre.class))
                    .withDirectorName("director-" + movieId)
                    .withCast(List.of())
                    .withReleaseYear(RandomUtils.randomYear())
                    .build();
        }

        public static Movie generateMovie() {
            return MovieBuilder.aMovie()
                    .withName(RandomUtils.randomTitle())
                    .withGenre(RandomUtils.randomEnum(Genre.class))
                    .withDirectorName(RandomUtils.randomName())
                    .withCast(RandomUtils.randomNameList())
                    .withReleaseYear(RandomUtils.randomYear())
                    .build();
        }
    }

    public static final class MovieBuilder {
        private Long id;
        private String name;
        private Genre genre;
        private Integer releaseYear;
        private String directorName;
        private List<String> cast;
        private Integer rating = 0;

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

        public MovieBuilder withRating(Integer rating) {
            this.rating = rating;
            return this;
        }

        public Movie build() {
            Movie movie = new Movie();
            movie.setId(id);
            movie.setName(name);
            movie.setGenre(genre);
            movie.setReleaseYear(releaseYear);
            movie.setDirectorName(directorName);
            movie.setCast(cast);
            movie.setRating(rating);
            return movie;
        }
    }
}
