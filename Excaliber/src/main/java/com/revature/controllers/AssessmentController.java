package com.revature.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Assessment")
public class AssessmentController {
	private final RestTemplate restTemplate;

	@Autowired
	public AssessmentController(RestTemplate restTemplateParam){
        restTemplate = restTemplateParam;
	}
	
	@GetMapping(value = "/assessments/{batch}/{week}")
    public String getAssessmentsByBatchIdAndWeek(@PathVariable("batch") String batchId, @PathVariable("week") int week) {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	HttpEntity <String> entity = new HttpEntity<String>(headers);
    		
    	return restTemplate.exchange("https://caliber2-mock.revaturelabs.com/mock/evaluation/assessments?batchId=" + batchId + "&week=" + week, HttpMethod.GET, entity, String.class).getBody();
    }
	
	@GetMapping(value = "/assessment/grade/{assessmentId}")
	public String getAverageAssessmentGradeById(@PathVariable("assessmentId") int assessmentId) {
		HttpHeaders headers = new HttpHeaders();
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	HttpEntity <String> entity = new HttpEntity<String>(headers);
    		
    	return restTemplate.exchange("https://caliber2-mock.revaturelabs.com/mock/evaluation/grades/average?assessment="
    	+ assessmentId, HttpMethod.GET, entity, String.class).getBody();
    
	}
}
