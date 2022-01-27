package com.example.week3.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.example.week3.model.enums.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Builder
@Table(name = "movie")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(nullable = false)
    private String director;

    @ElementCollection
    private List<String> cast;

    private Integer releaseYear;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn( name = "movie_id", referencedColumnName = "id")
    private Set<RateEntity> rates = new HashSet<>();



}
