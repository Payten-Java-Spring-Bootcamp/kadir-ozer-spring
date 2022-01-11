package com.example.week3.service;

import com.example.week3.model.response.MovieResponse;
import com.example.week3.model.response.MovieResponse.MovieBuilder;
import com.example.week3.model.request.MovieAddRequest;
import com.example.week3.util.ObjectGenerator;
import com.example.week3.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MovieService {

    private static final Integer DUMMY_SIZE = RandomUtils.random.nextInt(20);

    public MovieResponse add(MovieAddRequest request) {
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
    public List<MovieResponse> getAll() {
        List<MovieResponse> movieList = new ArrayList<>();
        for (int i = 0; i < DUMMY_SIZE; i++) {
            movieList.add(ObjectGenerator.RandomMovieGenerator.generateMovie());
        }
        return movieList;
    }

    // Generate random Movie using Id and return
    public MovieResponse getById(Long movieId) {
        return ObjectGenerator.RandomMovieGenerator.generateMovieById(movieId);

    }

    public void deleteMovieById(Long movieId) {
        log.info("Movie is deleted successfully movieId:{}",movieId);
    }

    public MovieResponse updateMovieById(Long movieId, MovieAddRequest request) {
        var movie = ObjectGenerator.RandomMovieGenerator.generateMovieById(movieId);
        movie.setCast(request.getCast());
        movie.setGenre(request.getGenre());
        movie.setName(request.getName());
        movie.setDirectorName(request.getDirectorName());
        movie.setReleaseYear(request.getReleaseYear());
        return movie;
    }


}
