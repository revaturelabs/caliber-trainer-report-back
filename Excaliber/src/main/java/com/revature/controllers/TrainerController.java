package com.revature.controllers;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.Trainer;
import com.revature.services.StoreRetrieveService;

/**
 * The type Json controller.
 */
@RestController
@RequestMapping(path = "/Trainer")
public class TrainerController {
	@Autowired
	RestTemplate restTemplate;

    private final StoreRetrieveService SRSserv;

    @Autowired
    public TrainerController(StoreRetrieveService srSserv) {
        SRSserv = srSserv;
    }

    @GetMapping
    public ResponseEntity<List<Trainer>> getTrainers() {
        return ResponseEntity.ok(SRSserv.getTrainers());
    }

    @GetMapping(path = "/{trainerId}")
    public ResponseEntity<Trainer> getTrainers(@PathVariable int trainerId) {
        return ResponseEntity.ok(SRSserv.getTrainerById(trainerId));
    }
    
    @RequestMapping(path = "/trainer")
    public String getEndpointTrainers() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	HttpEntity <String> entity = new HttpEntity<String>(headers);
    	return restTemplate.exchange("https://swapi.dev/api/people/", HttpMethod.GET, entity, String.class).getBody();
    	
    }
    @Bean
    public RestTemplate restTemplate() {
    	return new RestTemplate();
    }
    
}
