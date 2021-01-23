package com.example.legal.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.example.legal.entity.RecommendationEntity;
import com.example.legal.model.Recommendation;

@Component
public class RecommendationMapper {

    public RecommendationEntity convertModelToEntity(Recommendation recoToMap){
    	RecommendationEntity recoToBeMapped = new RecommendationEntity();
    	recoToBeMapped.setId(generateUUID(recoToMap.getId()));
    	recoToBeMapped.setTitle(recoToMap.getTitle());
    	recoToBeMapped.setCompany(recoToMap.getCompany());
    	recoToBeMapped.setDescription(recoToMap.getDescription());
    	recoToBeMapped.setDesignation(recoToMap.getDesignation());
        return recoToBeMapped;
    }

    public Recommendation convertEntityToModel(RecommendationEntity recoEntityToMap){
    	Recommendation recoToBeMapped = new Recommendation();
    	recoToBeMapped.setId(recoEntityToMap.getId().toString());
    	recoToBeMapped.setTitle(recoEntityToMap.getTitle());
    	recoToBeMapped.setDesignation(recoEntityToMap.getDesignation());
    	recoToBeMapped.setCompany(recoEntityToMap.getCompany());
    	recoToBeMapped.setDescription(recoEntityToMap.getDescription());
        return recoToBeMapped;
    }

    private UUID generateUUID(String uuid){
        if(StringUtils.isEmpty(uuid)) return UUID.randomUUID();
        else return UUID.fromString(uuid);
    }


}
