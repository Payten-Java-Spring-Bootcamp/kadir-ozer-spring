package com.example.week3.controller;

import com.example.week3.model.request.RateAddRequest;
import com.example.week3.model.response.MemberResponse;
import com.example.week3.model.response.MovieResponse;
import com.example.week3.model.response.RateResponse;
import com.example.week3.model.response.WatchListResponse;
import com.example.week3.service.RateService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rate")
public class RateController {

    private final RateService rateService;

    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @PostMapping
    public RateResponse rateMovie(@RequestBody @Valid RateAddRequest request) {
        final var rate = rateService.add(request.convert());

        return rate.toResponse();
    }

//    @PostMapping("/{memberId}/watchlist/add")
//    @ResponseStatus(HttpStatus.CREATED)
//    public MemberResponse createWatchList(@PathVariable Long memberId, @RequestParam String watchListName) {
//        return memberService.createWatchList(memberId,watchListName);
//    }
//
//    @PutMapping("/{watchListId}/addMovie")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public WatchListResponse addMovieToWatchList(@PathVariable Long watchListId, @RequestParam List<Long> movieIds) {
//        return memberService.addMovieToWatchList(watchListId,movieIds);
//    }
}
