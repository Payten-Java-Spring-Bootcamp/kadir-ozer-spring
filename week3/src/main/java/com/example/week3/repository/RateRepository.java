package com.example.week3.repository;

import com.example.week3.model.entity.RateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepository extends JpaRepository<RateEntity, Long> {
}
