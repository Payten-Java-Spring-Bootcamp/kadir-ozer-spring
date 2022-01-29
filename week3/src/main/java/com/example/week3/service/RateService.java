package com.example.week3.service;

import com.example.week3.model.Rate;
import com.example.week3.repository.RateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RateService {

    private final RateRepository rateRepository;
    private final MovieService movieService;

    public RateService(RateRepository rateRepository, MovieService movieService, MemberService memberService) {
        this.rateRepository = rateRepository;
        this.movieService = movieService;
    }

    public Rate add(Rate rate) {
        final var movieEntity = movieService.getEntityById(rate.getMovieId());
        final var newEntity = rateRepository.save(Rate.convertToEntity(rate,movieEntity));
        return Rate.convertFromEntity(newEntity);
    }
}
