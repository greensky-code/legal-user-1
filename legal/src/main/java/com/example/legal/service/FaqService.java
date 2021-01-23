package com.example.legal.service;

import java.util.List;

import com.example.legal.model.ServiceFaq;

public interface FaqService {
	ServiceFaq createFaq(ServiceFaq faq);
	void deleteFaq(String faqId);
	ServiceFaq updateFaq(String userUuid, ServiceFaq serviceFaq);
	List<ServiceFaq> getProfileFaqs();
	List<ServiceFaq> getServiceFaqs(String serviceId);
}