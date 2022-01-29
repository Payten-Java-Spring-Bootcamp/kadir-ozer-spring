package com.example.week3.controller;

import com.example.week3.model.WatchList;
import com.example.week3.model.request.WatchListAddRequest;
import com.example.week3.model.response.WatchListResponse;
import com.example.week3.service.WatchListService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/watchlist")
public class WatchListController {

    private final WatchListService watchListService;

    public WatchListController(WatchListService watchListService) {
        this.watchListService = watchListService;
    }


    @PostMapping("/{memberId}/add")
    @ResponseStatus(HttpStatus.CREATED)
    public WatchListResponse createWatchList(@RequestBody @Valid WatchListAddRequest request) {
        final var watchList = watchListService.add(request.convert());
        return watchList.toResponse();
    }

    @GetMapping("/list-all")
    public Set<WatchListResponse> listAll(){
        final var watchLists = watchListService.getAll();
        return watchLists.stream().map(WatchList::toResponse).collect(Collectors.toSet());
    }
}
