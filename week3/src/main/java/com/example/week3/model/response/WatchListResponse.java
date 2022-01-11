package com.example.week3.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class WatchListResponse {
    private Long id;
    private String name;
    private List<Long> movies;

    public void addMoviesToList(List<Long> movieIds) {
        this.movies.addAll(movieIds);
    }

    public static final class WatchListBuilder {
        private Long id;
        private String name;
        private List<Long> movies;

        private WatchListBuilder() {
        }

        public static WatchListBuilder aWatchList() {
            return new WatchListBuilder();
        }

        public WatchListBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public WatchListBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public WatchListBuilder withMovies(List<Long> movies) {
            this.movies = movies;
            return this;
        }

        public WatchListResponse build() {
            WatchListResponse watchListResponse = new WatchListResponse();
            if (id != null)
                watchListResponse.setId(id);
            watchListResponse.setName(name);
            watchListResponse.setMovies(movies);
            return watchListResponse;
        }
    }

}
