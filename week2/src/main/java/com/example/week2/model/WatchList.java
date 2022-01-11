package com.example.week2.model;

import com.example.week2.util.RandomUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class WatchList {
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

        public WatchList build() {
            WatchList watchList = new WatchList();
            if (id != null)
                watchList.setId(id);
            watchList.setName(name);
            watchList.setMovies(movies);
            return watchList;
        }
    }

    public static final class RandomWatchListGenerator {

        private RandomWatchListGenerator(){
            throw new IllegalStateException("Generator class");
        }
        public static WatchList generateWatchList() {
            return WatchListBuilder.aWatchList()
                    .withName(RandomUtils.randomFunnyName())
                    .withMovies(RandomUtils.randomLongList())
                    .build();
        }

        public static WatchList generateWatchListById(Long watchListId) {
            return WatchListBuilder.aWatchList()
                    .withId(watchListId)
                    .withName(RandomUtils.randomName())
                    .withMovies(RandomUtils.randomLongList())
                    .build();
        }
    }
}
