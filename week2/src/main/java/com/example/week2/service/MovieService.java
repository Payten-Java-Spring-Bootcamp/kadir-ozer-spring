package com.example.week2.service;

import com.example.week2.model.Movie;
import com.example.week2.model.Movie.MovieBuilder;
import com.example.week2.model.request.MovieAddRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class MovieService {

    private static final Integer DUMMY_SIZE = new Random().nextInt(20);

    public Movie add(MovieAddRequest request) {
        final var newMovie = MovieBuilder.aMovie()
                .withCast(request.getCast())
                .withDirectorName(request.getDirectorName())
                .withGenre(request.getGenre())
                .withName(request.getName())
                .withReleaseYear(request.getReleaseYear())
                .build();

        log.info("New Movie is created successfully Movie:{}", newMovie);
        return newMovie;
    }


    // Generates and returns random Movies
    public List<Movie> getAll() {
        List<Movie> movieList = new ArrayList<>();
        for (int i = 0; i < DUMMY_SIZE; i++) {
            movieList.add(Movie.RandomMovieGenerator.generateMovie());
        }
        return movieList;
    }

    // Generate random Movie using Id and return
    public Movie getById(Long movieId) {
        return Movie.RandomMovieGenerator.generateMovieById(movieId);

    }

    public void deleteMovieById(Long movieId) {
    }

    public Movie updateMovieById(Long movieId, MovieAddRequest request) {
        var movie = Movie.RandomMovieGenerator.generateMovieById(movieId);
        movie.setCast(request.getCast());
        movie.setGenre(request.getGenre());
        movie.setName(request.getName());
        movie.setDirectorName(request.getDirectorName());
        movie.setReleaseYear(request.getReleaseYear());
        return movie;
    }


}
