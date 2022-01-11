package com.example.week3.repository;

import com.example.week3.model.entity.WatchListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchListRepository extends JpaRepository<WatchListEntity, Long> {
}
