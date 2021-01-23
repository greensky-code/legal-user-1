package com.example.legal.model;

import lombok.Data;

@Data
public class ServiceFaq {
	private String id;
	private String question;
	private String relatedService;
	private String answer;
}
