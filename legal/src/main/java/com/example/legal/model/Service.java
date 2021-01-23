package com.example.legal.model;

import javax.validation.constraints.NotEmpty;

import lombok.Data;


@Data
public class Service {
	private String id;
	@NotEmpty
	private String title;
	private String categoryId;
	private String subCategoryId;
	private String description;
	private ServiceRequirement serviceRequirement;
	private String languageId;
    private Integer timeTaken;
    private long price;
    private Integer revision;
}
