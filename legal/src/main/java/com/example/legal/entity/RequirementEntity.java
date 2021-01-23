package com.example.legal.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "service_requirement")
@Data
public class RequirementEntity {
	@Id
    private UUID id = UUID.randomUUID();
    private String text;
    private String formId;
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    @ManyToOne
    private ServiceEntity service;

}
