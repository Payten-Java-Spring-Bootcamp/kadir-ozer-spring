package com.example.week3.service;

import com.example.week3.model.Movie;
import com.example.week3.model.entity.MovieEntity;
import com.example.week3.model.request.MovieAddRequest;
import com.example.week3.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie add(Movie movie) {
        final var newEntity = movieRepository.save(Movie.convertToEntity(movie));

        log.info("New Movie is created successfully Movie:{}", newEntity);
        return Movie.convertFromEntity(newEntity);
    }

    public List<Movie> getAll() {
        List<MovieEntity> movieList = movieRepository.findAll();
        return movieList.stream().map(Movie::convertFromEntity).collect(Collectors.toList());
    }

    public Movie getById(Long movieId) {
        final var movieEntity = movieRepository.getById(movieId);
        return Movie.convertFromEntity(movieEntity);
    }

    public void deleteMovieById(Long movieId) {
        log.info("Movie is deleted successfully movieId:{}", movieId);
    }

    public Movie updateMovieById(Long movieId, MovieAddRequest request) {
        return null;
    }


    protected MovieEntity getEntityById(Long movieId) {
        return movieRepository.getById(movieId);
    }

    protected Set<MovieEntity> findAllMoviesByIdList(Set<Long> movieIdList) {
        return new HashSet<>(movieRepository.findAllByIdIn(movieIdList));
    }
}
