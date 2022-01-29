package com.example.week3.controller;

import com.example.week3.model.Movie;
import com.example.week3.model.request.MovieAddRequest;
import com.example.week3.model.response.MovieResponse;
import com.example.week3.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MovieResponse addMovie(@RequestBody MovieAddRequest request) {
        final var newMovie = movieService.add(request.convert());
        return newMovie.toResponse();
    }

    @GetMapping("/list-all")
    public List<MovieResponse> listMovies() {
        final var movieList = movieService.getAll();
        return movieList.stream().map(Movie::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{movieId}/detail")
    public MovieResponse showMovie(@PathVariable Long movieId) {
        final var movie = movieService.getById(movieId);
        return movie.toResponse();
    }

    @PutMapping("/{movieId}/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MovieResponse updateMovie(@PathVariable Long movieId, @RequestBody MovieAddRequest request) {
        return movieService.updateMovieById(movieId, request).toResponse();
    }

    @DeleteMapping("/{movieId}/remove")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeMovie(@PathVariable Long movieId) {
        movieService.deleteMovieById(movieId);
    }
}
