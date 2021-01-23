package com.example.legal.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.example.legal.entity.FaqEntity;
import com.example.legal.model.ServiceFaq;

@Component
public class FaqMapper {

    public FaqEntity convertModelToEntity(ServiceFaq faqModelToMap){
    	FaqEntity faqEntity = new FaqEntity();
    	faqEntity.setId(generateUUID(faqModelToMap.getId()));
    	faqEntity.setRelatedService(faqModelToMap.getRelatedService());
    	faqEntity.setQuestion(faqModelToMap.getQuestion());
    	faqEntity.setAnswer(faqModelToMap.getAnswer());
        return faqEntity;
    }

    public ServiceFaq convertEntityToModel(FaqEntity faqEntityToMap){
    	ServiceFaq faqModelToBeMapped = new ServiceFaq();
    	faqModelToBeMapped.setId(faqEntityToMap.getId().toString());
    	faqModelToBeMapped.setRelatedService(faqEntityToMap.getRelatedService());
    	faqModelToBeMapped.setQuestion(faqEntityToMap.getQuestion());
    	faqModelToBeMapped.setAnswer(faqEntityToMap.getAnswer());
        return faqModelToBeMapped;
    }

    private UUID generateUUID(String uuid){
        if(StringUtils.isEmpty(uuid)) return UUID.randomUUID();
        else return UUID.fromString(uuid);
    }

}
