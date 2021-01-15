package com.revature.controllers;


import java.util.Arrays;
import java.util.List;

import com.revature.services.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.revature.beans.Batch;


import com.revature.beans.Trainer;
import com.revature.services.TrainerService;

/**
 * The type Json controller.
 */
@RestController
@RequestMapping(path = "/Trainer")
public class TrainerController {

    private final TrainerService SRSserv;
    private final BatchService batchService;
	private final RestTemplate restTemplate;

    @Autowired
    public TrainerController(TrainerService srSservParam, RestTemplate restTemplateParam, BatchService b) {
        SRSserv = srSservParam;
        restTemplate = restTemplateParam;
        batchService = b;
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
    	return restTemplate.exchange("https://caliber2-mock.revaturelabs.com/mock/training/batch/trainers", HttpMethod.GET, entity, String.class).getBody();
    	
    }

    @GetMapping(path = "/batches/{trainerId}")
    public ResponseEntity<List<Batch>> getTrainerBatches(@PathVariable int trainerId) {
    	return ResponseEntity.ok(batchService.getBatchesByTrainer(trainerId));
    }

}

