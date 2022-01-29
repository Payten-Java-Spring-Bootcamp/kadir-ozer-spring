package com.example.week3.model.entity;

import lombok.*;

import javax.persistence.*;

import com.example.week3.model.enums.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "movie")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(nullable = false)
    private String director;

    @ElementCollection
    @CollectionTable(name = "movie_players", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "players")
    private Set<String> cast = new HashSet<>();

    private Integer releaseYear;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RateEntity> rates = new HashSet<>();

}
