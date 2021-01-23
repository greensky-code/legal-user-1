package com.example.legal.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.legal.model.Recommendation;
import com.example.legal.model.Requirement;
import com.example.legal.model.Service;
import com.example.legal.model.ServiceFaq;
import com.example.legal.service.FaqService;
import com.example.legal.service.RecommendationService;

@RestController
@RequestMapping(value = "/v01/user")
public class UserController {
	
	private final RecommendationService recoService;
	private final FaqService faqService;
	
	@Autowired
	public UserController(RecommendationService recoService, FaqService faqService) {
		this.recoService = recoService;
		this.faqService = faqService;
	}
	
	@PostMapping(value = "/recommendation" , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Recommendation> createRecommendation(@RequestBody Recommendation recommendation) throws IOException {
		Recommendation urecoCreated = recoService.createRecommendation(recommendation);
		return new ResponseEntity<>(urecoCreated, new HttpHeaders(), HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/faq", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceFaq> createFaq(@RequestBody ServiceFaq serviceFaq) throws IOException {
		ServiceFaq faq = faqService.createFaq(serviceFaq);
		return new ResponseEntity<>(faq, new HttpHeaders(), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{recoId}/recommendation", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Recommendation> updateRecommendation(@PathVariable String recoId, @RequestBody Recommendation recommendation) throws IOException {
		Recommendation recoUpdate = recoService.updateRecommendation(recoId, recommendation);
		return new ResponseEntity<>(recoUpdate, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping(value = "/{faqId}/faq", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceFaq> updateFaq(@PathVariable String userUuid, @RequestBody ServiceFaq serviceFaq) throws IOException {
		ServiceFaq faq = faqService.updateFaq(userUuid, serviceFaq);
		return new ResponseEntity<>(faq, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/faqs", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ServiceFaq>> getProfileFaq() throws IOException {
		List<ServiceFaq> faqs = faqService.getProfileFaqs();
		return new ResponseEntity<>(faqs, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/faqs/{serviceid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ServiceFaq>> getServiceFaq(@PathVariable String serviceid) throws IOException {
		List<ServiceFaq> faqs = faqService.getServiceFaqs(serviceid);
		return new ResponseEntity<>(faqs, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/recommendations", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Recommendation>> getRecommendation() throws IOException {
		List<Recommendation> faq = recoService.getRecommendations();
		return new ResponseEntity<>(faq, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/faq/{id}")
	public ResponseEntity deleteFaq(@PathVariable String faqId) throws IOException {
		faqService.deleteFaq(faqId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/recommendation/{id}")
	public ResponseEntity deleteRecommendation(@PathVariable String recoId) throws IOException {
		recoService.deleteRecommendation(recoId);
		return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/service" , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Recommendation> createService(@RequestBody Recommendation recommendation) throws IOException {
		Recommendation urecoCreated = recoService.createRecommendation(recommendation);
		return new ResponseEntity<>(urecoCreated, new HttpHeaders(), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/service" , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Service> getServices(@RequestBody Service service) throws IOException {
		Service serviceCreated = recoService.createService(service);
		return new ResponseEntity<>(serviceCreated, new HttpHeaders(), HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/requirement" , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Requirement> createRequirement(@RequestBody Requirement requirement) throws IOException {
		Requirement requirementCreated = recoService.createServiceRequirement(requirement);
		return new ResponseEntity<>(requirementCreated, new HttpHeaders(), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/requirement")
	public ResponseEntity<List<Requirement>> createRequirements() throws IOException {
		List<Requirement> requirements = recoService.getServiceRequirement();
		return new ResponseEntity<>(requirements, new HttpHeaders(), HttpStatus.OK);
	}
}
