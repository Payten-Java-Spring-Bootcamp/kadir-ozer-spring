package com.example.week3.model.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Builder
@Table(name = "watchlist")
public class WatchListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "watchlist_movie",
            joinColumns = { @JoinColumn(name = "watchlist_id") },
            inverseJoinColumns = { @JoinColumn(name = "movie_id") })
    private Set<MovieEntity> movieList = new HashSet<>();
}
