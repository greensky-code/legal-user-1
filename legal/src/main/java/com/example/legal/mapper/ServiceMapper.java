package com.example.legal.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.example.legal.entity.RequirementEntity;
import com.example.legal.entity.ServiceEntity;
import com.example.legal.model.Requirement;
import com.example.legal.model.Service;
import com.example.legal.model.ServiceRequirement;

@Component
public class ServiceMapper {
	private final RequirementMapper reqMapper;
	
	public ServiceMapper(RequirementMapper reqMapper) {
		this.reqMapper = reqMapper;
	}

    public ServiceEntity convertModelToEntity(Service serviceToMap){
    	ServiceEntity serviceToBeMapped = new ServiceEntity();
    	serviceToBeMapped.setId(generateUUID(serviceToMap.getId()));
    	serviceToBeMapped.setTitle(serviceToMap.getTitle());
    	serviceToBeMapped.setDescription(serviceToMap.getDescription());
    	serviceToBeMapped.setCategoryId(serviceToMap.getCategoryId());
    	serviceToBeMapped.setSubCategoryId(serviceToMap.getSubCategoryId());
    	serviceToBeMapped.setLanguageId(serviceToMap.getLanguageId());
    	serviceToBeMapped.setPrice(serviceToMap.getPrice());
    	serviceToBeMapped.setRevision(serviceToMap.getRevision());
    	serviceToBeMapped.setRequirements(getRequirementFromModel(serviceToMap.getServiceRequirement().getRequirements()));

        return serviceToBeMapped;
    }

    public Service convertEntityToModel(ServiceEntity serviceEntityToMap){
    	Service serviceToBeMapped = new Service();
    	serviceToBeMapped.setId(serviceEntityToMap.getId().toString());
    	serviceToBeMapped.setTitle(serviceEntityToMap.getTitle());
    	serviceToBeMapped.setDescription(serviceEntityToMap.getDescription());
    	serviceToBeMapped.setLanguageId(serviceEntityToMap.getLanguageId());
    	serviceToBeMapped.setSubCategoryId(serviceEntityToMap.getSubCategoryId());
    	serviceToBeMapped.setPrice(serviceEntityToMap.getPrice());
    	serviceToBeMapped.setRevision(serviceEntityToMap.getRevision());
    	serviceToBeMapped.setServiceRequirement(getRequirementFromEntity(serviceEntityToMap.getRequirements()));

        return serviceToBeMapped;
    }

    private UUID generateUUID(String uuid){
        if(StringUtils.isEmpty(uuid)) return UUID.randomUUID();
        else return UUID.fromString(uuid);
    }

	private List<RequirementEntity> getRequirementFromModel(List<Requirement> reuirements) {
		List<RequirementEntity> requirementEntity = new ArrayList<>();
		for(Requirement requirement : reuirements){
			requirementEntity.add(reqMapper.convertModelToEntity(requirement));
		}
		return requirementEntity;
	}
	
	private ServiceRequirement getRequirementFromEntity(List<RequirementEntity> requirements) {
		ServiceRequirement serviceReq = new ServiceRequirement();
		List<Requirement> requirementList = new ArrayList<>();
		if(Objects.nonNull(requirements)){
			for(RequirementEntity skill : requirements){
				requirementList.add(reqMapper.convertEntityToModel(skill));
			}
		}
		serviceReq.setRequirements(requirementList);
		return serviceReq;
	}
}
