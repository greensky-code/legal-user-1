package com.example.legal.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.legal.entity.FaqEntity;
import com.example.legal.exception.BusinessServiceException;
import com.example.legal.exception.ErrorType;
import com.example.legal.mapper.FaqMapper;
import com.example.legal.model.ServiceFaq;
import com.example.legal.repository.FaqServiceRepository;

@Service
public class FaqServiceImpl implements FaqService {

	private FaqServiceRepository faqRepo;
	private final FaqMapper faqMapper;

	public FaqServiceImpl(FaqServiceRepository faqRepo, FaqMapper faqMapper) {
		this.faqRepo = faqRepo;
		this.faqMapper = faqMapper;
	}

	@Override
	public ServiceFaq createFaq(ServiceFaq faq) {
		//UserEntity userFound = userRepo.findById(UUID.fromString(userId)).orElseThrow(() -> new BusinessServiceException("The user does not exist", BUSINESS_ERROR));
		FaqEntity recoToCreateEntity = faqMapper.convertModelToEntity(faq);
		//recoToCreateEntity.setUser(userFound);
		FaqEntity faqCreatedEntity = faqRepo.save(recoToCreateEntity);
		ServiceFaq faqCreated = faqMapper.convertEntityToModel(faqCreatedEntity);		
		return faqCreated;

	}

	@Override
	public void deleteFaq(String faqId) {
		FaqEntity faqFoundEntity = faqRepo.findById(UUID.fromString(faqId)).orElseThrow(() -> new BusinessServiceException("The Faq does not exist", ErrorType.BUSINESS_ERROR));
		faqRepo.delete(faqFoundEntity);

	}

	@Override
	public ServiceFaq updateFaq(String userUuid, ServiceFaq serviceFaq) {
		FaqEntity faqUpdateEntity = faqMapper.convertModelToEntity(serviceFaq);
		faqUpdateEntity.setId(UUID.fromString(userUuid));
		FaqEntity faqUpdatedEntity = faqRepo.save(faqUpdateEntity);
		ServiceFaq faqUpdated = faqMapper.convertEntityToModel(faqUpdatedEntity);
		return faqUpdated;
	}

	@Override
	public List<ServiceFaq> getProfileFaqs() {
		List<FaqEntity> allFaq = faqRepo.findAll();
		List<ServiceFaq> faqFound = null;
		if(Objects.nonNull(allFaq)) faqFound = allFaq.stream().map(faqEntity -> 
		faqMapper.convertEntityToModel(faqEntity)).collect(Collectors.toList());		
		return faqFound;
	}


	@Override
	public List<ServiceFaq> getServiceFaqs(String serviceId) {
		List<FaqEntity> allFaq = faqRepo.findAllFaqByService(serviceId);
		List<ServiceFaq> faqFound = null;
		if(Objects.nonNull(allFaq)) faqFound = allFaq.stream().map(faqEntity -> 
		faqMapper.convertEntityToModel(faqEntity)).collect(Collectors.toList());		
		return faqFound;
	}

}
