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
@RequestMapping("/QCNote")
public class QCNoteController {
	private final RestTemplate restTemplate;
    
    @Autowired
    public QCNoteController(RestTemplate restTemplateParam){
        restTemplate = restTemplateParam;
    }

	@GetMapping(value = "/qcNotes/{id}")
    public String getQCNotesByBatchId(@PathVariable("id") String batchId) {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	HttpEntity <String> entity = new HttpEntity<String>(headers);
    		
    	return restTemplate.exchange("https://caliber2-mock.revaturelabs.com/mock/qa/notes/batch/"+batchId, HttpMethod.GET, entity, String.class).getBody();
    }
	
	@GetMapping(value = "/qcNote/{batch}/category/{week}")
	public String getCategoryByWeek(@PathVariable("batch") String batchId, @PathVariable("week") int week) {
		HttpHeaders headers = new HttpHeaders();
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	HttpEntity <String> entity = new HttpEntity<String>(headers);
    		
    	return restTemplate.exchange("https://caliber2-mock.revaturelabs.com/mock/qa/category/" 
    	+ batchId + "/" + week, HttpMethod.GET, entity, String.class).getBody();
  
	}
}
