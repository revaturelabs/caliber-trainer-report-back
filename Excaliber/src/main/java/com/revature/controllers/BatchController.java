package com.revature.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Batch")
public class BatchController {
	
	@Autowired
	RestTemplate restTemplate;
	
    @PostMapping(value = "/batches")
    public String getEndpointBatchIdsByTrainerEmail(@RequestBody(required = true) String email) {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	HttpEntity <String> entity = new HttpEntity<String>(headers);
    		
    	return restTemplate.exchange("https://caliber2-mock.revaturelabs.com/mock/training/batch/" + email + "/ids", HttpMethod.GET, entity, String.class).getBody();
    	
    }

}
