package com.example.legal.service;

import java.util.List;

import com.example.legal.model.Recommendation;
import com.example.legal.model.Requirement;
import com.example.legal.model.Service;

public interface RecommendationService {
	Recommendation createRecommendation(Recommendation recommendation);
	void deleteRecommendation(String recoId);
	List<Recommendation> getRecommendations();
	Recommendation updateRecommendation(String recoId, Recommendation recommendation);
	Service createService(Service service);
	List<Service> getServices();
	Requirement createServiceRequirement(Requirement requirement);
	List<Requirement> getServiceRequirement();

}
