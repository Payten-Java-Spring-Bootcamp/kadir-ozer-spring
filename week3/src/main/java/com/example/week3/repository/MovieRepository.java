package com.example.week3.repository;

import com.example.week3.model.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

    List<MovieEntity> findAllByIdIn(Set<Long> idList);
}
