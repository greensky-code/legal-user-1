package com.example.legal.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.legal.entity.RequirementEntity;

@Repository
public interface RequirementRepository extends JpaRepository<RequirementEntity, UUID>{
/*
	@Query(value = "SELECT * FROM faq where related_service = ?1", nativeQuery = true)
	List<FaqEntity> findAllFaqByService(String serviceId);
	@Query(value = "SELECT * FROM faq WHERE user_id = ?1", nativeQuery = true)
	List<FaqEntity> findByUser(UUID userId)*/;

}
