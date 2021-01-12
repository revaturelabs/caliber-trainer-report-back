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
@RequestMapping("/Category")
public class CategoryService {

	private final RestTemplate restTemplate;
	
	@Autowired
	public CategoryService(RestTemplate restTemplateParam){
        restTemplate = restTemplateParam;
	}

	@GetMapping(value = "/category/{id}")
    public String getQCNotesByBatchId(@PathVariable("id") int id) {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	HttpEntity <String> entity = new HttpEntity<String>(headers);
    		
    	return restTemplate.exchange("https://caliber2-mock.revaturelabs.com/mock/category/category/" + id, HttpMethod.GET, entity, String.class).getBody();
    }
}
