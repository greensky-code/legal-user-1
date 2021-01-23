package com.example.legal.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.legal.entity.RecommendationEntity;

@Repository
public interface RecommendationRepository extends JpaRepository<RecommendationEntity, UUID> {

}
