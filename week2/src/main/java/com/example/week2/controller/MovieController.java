package com.example.week2.controller;

import com.example.week2.model.Member;
import com.example.week2.model.Movie;
import com.example.week2.model.request.MovieAddRequest;
import com.example.week2.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/add")
    public Movie addMovie(@RequestBody MovieAddRequest request) {
        return movieService.add(request);
    }

    @GetMapping("/list-all")
    public List<Movie> listMovies() {
        return movieService.getAll();
    }

    @GetMapping("/{movieId}/detail")
    public Movie showMovie(@PathVariable Long movieId) {
        return movieService.getById(movieId);
    }

    @PutMapping("/{movieId}/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Movie updateMovie(@PathVariable Long movieId, @RequestBody MovieAddRequest request) {
        return movieService.updateMovieById(movieId, request);
    }

    @DeleteMapping("/{movieId}/remove")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeMovie(@PathVariable Long movieId) {
        movieService.deleteMovieById(movieId);
    }
}
