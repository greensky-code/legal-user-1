package com.example.legal.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.legal.entity.RecommendationEntity;
import com.example.legal.entity.RequirementEntity;
import com.example.legal.entity.ServiceEntity;
import com.example.legal.exception.BusinessServiceException;
import com.example.legal.exception.ErrorType;
import com.example.legal.mapper.RecommendationMapper;
import com.example.legal.mapper.RequirementMapper;
import com.example.legal.mapper.ServiceMapper;
import com.example.legal.model.Recommendation;
import com.example.legal.model.Requirement;
import com.example.legal.repository.RecommendationRepository;
import com.example.legal.repository.RequirementRepository;
import com.example.legal.repository.ServiceRepository;

@Service
public class RecommendationServiceImpl implements RecommendationService {

	private RecommendationRepository recoRepo;
	private RequirementRepository requirementRepo;
	private ServiceRepository serviceRepo;
	private final RecommendationMapper recoMapper;
	private final RequirementMapper requirementMapper;
	private final ServiceMapper serviceMapper;


	public RecommendationServiceImpl(RecommendationRepository recoRepo, RecommendationMapper recoMapper, 
			ServiceMapper serviceMapper, RequirementMapper requirementMapper, 
			RequirementRepository requirementRepo, ServiceRepository serviceRepo) {
		this.recoRepo = recoRepo;
		this.serviceRepo = serviceRepo;
		this.requirementRepo = requirementRepo;
		this.recoMapper = recoMapper;
		this.requirementMapper = requirementMapper;
		this.serviceMapper = serviceMapper;
	}

	@Override
	public Recommendation createRecommendation(Recommendation recommendation) {
		RecommendationEntity recoToCreateEntity = recoMapper.convertModelToEntity(recommendation);
		RecommendationEntity recoCreatedEntity = recoRepo.save(recoToCreateEntity);
		Recommendation recoCreated = recoMapper.convertEntityToModel(recoCreatedEntity);		
		return recoCreated;
	}

	@Override
	public void deleteRecommendation(String recoId) {
        RecommendationEntity recommendationFoundEntity = recoRepo.findById(UUID.fromString(recoId)).orElseThrow(() -> new BusinessServiceException("The certification does not exist", ErrorType.BUSINESS_ERROR));
        recoRepo.delete(recommendationFoundEntity);
    }

	@Override
	public List<Recommendation> getRecommendations() {
        List<RecommendationEntity> recoUpdatedEntity = recoRepo.findAll();
        List<Recommendation> recoFound = null;
        if(Objects.nonNull(recoUpdatedEntity)) recoFound = recoUpdatedEntity.stream().map(recoEntity -> 
        recoMapper.convertEntityToModel(recoEntity)).collect(Collectors.toList());
		return recoFound;
	}

	@Override
	public Recommendation updateRecommendation(String recoId, Recommendation recommendationToUpdate) {
        RecommendationEntity recoUpdateEntity = recoMapper.convertModelToEntity(recommendationToUpdate);
        recoUpdateEntity.setId(UUID.fromString(recoId));
        RecommendationEntity recoUpdatedEntity = recoRepo.save(recoUpdateEntity);
        Recommendation recoUpdated = recoMapper.convertEntityToModel(recoUpdatedEntity);
        return recoUpdated;
    }

	@Override
	public com.example.legal.model.Service createService(com.example.legal.model.Service service) {
		ServiceEntity serviceToCreateEntity = serviceMapper.convertModelToEntity(service);
		ServiceEntity serviceCreatedEntity = serviceRepo.save(serviceToCreateEntity);
		com.example.legal.model.Service requirementCreated = serviceMapper.convertEntityToModel(serviceCreatedEntity);		
		return requirementCreated;
	}

	@Override
	public List<com.example.legal.model.Service> getServices() {
        List<ServiceEntity> serviceUpdatedEntity = serviceRepo.findAll();
        List<com.example.legal.model.Service> serviceFound = null;
        if(Objects.nonNull(serviceUpdatedEntity)) serviceFound = serviceUpdatedEntity.stream().map(serviceEntity -> 
        serviceMapper.convertEntityToModel(serviceEntity)).collect(Collectors.toList());
		return serviceFound;
	}

	@Override
	public Requirement createServiceRequirement(Requirement requirement) {
		RequirementEntity requirementToCreateEntity = requirementMapper.convertModelToEntity(requirement);
		RequirementEntity requirementCreatedEntity = requirementRepo.save(requirementToCreateEntity);
		Requirement requirementCreated = requirementMapper.convertEntityToModel(requirementCreatedEntity);		
		return requirementCreated;
	}

	@Override
	public List<Requirement> getServiceRequirement() {
        List<RequirementEntity> requimentUpdatedEntity = requirementRepo.findAll();
        List<Requirement> requimentFound = null;
        if(Objects.nonNull(requimentUpdatedEntity)) requimentFound = requimentUpdatedEntity.stream().map(requimentEntity -> 
        requirementMapper.convertEntityToModel(requimentEntity)).collect(Collectors.toList());
		return requimentFound;
	}

}
