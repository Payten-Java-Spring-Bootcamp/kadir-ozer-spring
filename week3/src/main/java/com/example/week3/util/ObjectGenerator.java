package com.example.week3.util;

import com.example.week3.model.response.MemberResponse;
import com.example.week3.model.response.MovieResponse;
import com.example.week3.model.response.WatchListResponse;
import com.example.week3.model.enums.Genre;

import java.util.List;

public final class ObjectGenerator {

    public static final class RandomMemberGenerator {

        private RandomMemberGenerator() {
            throw new IllegalStateException("Generator Class");
        }

        public static MemberResponse generateMemberById(Long memberId) {
            return MemberResponse.MemberBuilder.aMember()
                    .withId(memberId)
                    .withEmail("user" + memberId.toString() + "@gmail.com")
                    .withBirthDate(RandomUtils.randomDate())
                    .withName("user" + memberId)
                    .build();
        }

        public static MemberResponse generateMember() {
            return MemberResponse.MemberBuilder.aMember()
                    .withEmail(RandomUtils.randomEmail())
                    .withName(RandomUtils.randomName())
                    .withBirthDate(RandomUtils.randomDate())
                    .build();
        }

    }

    public static final class RandomMovieGenerator {

        private RandomMovieGenerator() {
            throw new IllegalStateException("Generator Class");
        }

        public static MovieResponse generateMovieById(Long movieId) {
            return MovieResponse.MovieBuilder.aMovie()
                    .withId(movieId)
                    .withName("movie-" + movieId)
                    .withGenre(RandomUtils.randomEnum(Genre.class))
                    .withDirectorName("director-" + movieId)
                    .withCast(List.of())
                    .withReleaseYear(RandomUtils.randomYear())
                    .build();
        }

        public static MovieResponse generateMovie() {
            return MovieResponse.MovieBuilder.aMovie()
                    .withName(RandomUtils.randomTitle())
                    .withGenre(RandomUtils.randomEnum(Genre.class))
                    .withDirectorName(RandomUtils.randomName())
                    .withCast(RandomUtils.randomNameList())
                    .withReleaseYear(RandomUtils.randomYear())
                    .build();
        }
    }

    public static final class RandomWatchListGenerator {

        private RandomWatchListGenerator() {
            throw new IllegalStateException("Generator class");
        }

        public static WatchListResponse generateWatchList() {
            return WatchListResponse.WatchListBuilder.aWatchList()
                    .withName(RandomUtils.randomFunnyName())
                    .withMovies(RandomUtils.randomLongList())
                    .build();
        }

        public static WatchListResponse generateWatchListById(Long watchListId) {
            return WatchListResponse.WatchListBuilder.aWatchList()
                    .withId(watchListId)
                    .withName(RandomUtils.randomName())
                    .withMovies(RandomUtils.randomLongList())
                    .build();
        }
    }
}
