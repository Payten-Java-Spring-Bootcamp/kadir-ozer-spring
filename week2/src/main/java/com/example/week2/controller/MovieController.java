package com.example.week2.controller;

import com.example.week2.model.Movie;
import com.example.week2.model.request.MovieAddRequest;
import com.example.week2.service.MovieService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(name = "/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

//    @PostMapping("/add")
//    public Movie addMovie(@RequestBody MovieAddRequest request) {
//        return movieService.add(request);
//    }
}
