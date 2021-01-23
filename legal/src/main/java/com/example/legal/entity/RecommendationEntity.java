package com.example.legal.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user_recommendation")
@Data
public class RecommendationEntity {

    @Id
    private UUID id = UUID.randomUUID();
    private String title;
    private String designation;
    private String company;
    private String description;
}