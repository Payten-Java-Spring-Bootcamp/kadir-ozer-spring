package com.example.week2.service;

import com.example.week2.model.Movie;
import com.example.week2.model.Movie.MovieBuilder;
import com.example.week2.model.request.MovieAddRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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




}
