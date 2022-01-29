package com.example.week3.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "rate")
public class RateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date createdDate;

    @Column(nullable = false)
    private Integer point;

    @Column
    private Long memberId;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MovieEntity movie;
}