package com.example.legal.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.example.legal.entity.RequirementEntity;
import com.example.legal.model.Requirement;

@Component
public class RequirementMapper {

    public RequirementEntity convertModelToEntity(Requirement requimentToMap){
    	RequirementEntity requirementToBeMapped = new RequirementEntity();
    	requirementToBeMapped.setId(generateUUID(requimentToMap.getId()));
    	requirementToBeMapped.setText(requimentToMap.getText());
    	requirementToBeMapped.setFormId(requimentToMap.getFormId());
        return requirementToBeMapped;
    }

    public Requirement convertEntityToModel(RequirementEntity recoEntityToMap){
    	Requirement requirementToBeMapped = new Requirement();
    	requirementToBeMapped.setId(recoEntityToMap.getId().toString());
    	requirementToBeMapped.setText(recoEntityToMap.getText());
    	requirementToBeMapped.setFormId(recoEntityToMap.getFormId());
        return requirementToBeMapped;
    }

    private UUID generateUUID(String uuid){
        if(StringUtils.isEmpty(uuid)) return UUID.randomUUID();
        else return UUID.fromString(uuid);
    }

}
