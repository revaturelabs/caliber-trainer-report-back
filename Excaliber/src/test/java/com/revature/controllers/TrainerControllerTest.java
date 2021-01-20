package com.revature.controllers;

import org.apache.http.HttpStatus;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;
import com.revature.Excaliber;
import com.revature.beans.Batch;
import com.revature.beans.Trainer;
import com.revature.services.BatchService;
import com.revature.services.TrainerService;

import java.util.ArrayList;

import java.util.List;


import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = Excaliber.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = Excaliber.class)
@RunWith(MockitoJUnitRunner.class)
class TrainerControllerTest {
	
	@InjectMocks 
	private TrainerController trainerController; 
	@Mock
	private TrainerService SRSserv;
	
	@Mock
	private BatchService batchServ;
	
	@Mock
	RestTemplate restTemplate;
	
    @LocalServerPort 
    private Integer port;
    
 
    
    @Test 
    public void getTrainersTest() {
    	  List<Trainer> list = new ArrayList<Trainer>();
          Trainer trainer = new Trainer();         
          list.add(trainer);        
          when(SRSserv.getTrainers()).thenReturn(list);      
          ResponseEntity<java.util.List<Trainer>> response = trainerController.getTrainers();
           
          assertEquals(response.getStatusCodeValue(), HttpStatus.SC_OK);
          assertEquals(response.getBody().size(), list.size());
          verify(SRSserv, times(1)).getTrainers();
    }
    
    @Test 
    public void getTrainersTestWithID() {
          Trainer trainer = new Trainer();    
          
          when(SRSserv.getTrainerById(ArgumentMatchers.anyInt())).thenReturn(trainer);      
          ResponseEntity<Trainer> response = trainerController.getTrainers(1);
           
          assertEquals(response.getStatusCodeValue(), HttpStatus.SC_OK);
          verify(SRSserv, times(1)).getTrainerById(1);
    }
    
    @Test 
    public void getTrainersByIdTest() {
    	when(SRSserv.getTrainerById(1)).thenReturn(new Trainer("Lokesh","Gupta","user@email.com"));
        
        Trainer trainer = SRSserv.getTrainerById(1);
         
        assertEquals("Lokesh", trainer.getFirstName());
        assertEquals("Gupta", trainer.getLastName());
        assertEquals("user@email.com", trainer.getEmail());
    }
   
    
    
    @Test
    public void getEndPointTrainersTest() {
    	String response = null; 
    	ResponseEntity<String> responseEntity = new ResponseEntity<String>(response, org.springframework.http.HttpStatus.OK);
        Mockito.when(restTemplate.exchange(
                ArgumentMatchers.anyString(),
                ArgumentMatchers.any(HttpMethod.class),
                ArgumentMatchers.any(),
                ArgumentMatchers.<Class<String>>any()))
                .thenReturn(responseEntity);
  
        String endPointResponse = trainerController.getEndpointTrainers();  
        assertEquals(null, endPointResponse); 
    }
    
    @Test 
    public void getTrainerBatchesTest() {
    	int id = 1; 
  	    List<Batch> list = new ArrayList<Batch>();
        Batch batch = new Batch();         
        list.add(batch);   
    	when(batchServ.getBatchesByTrainer(id)).thenReturn(list);
    	
    	ResponseEntity<java.util.List<com.revature.beans.Batch>> response = trainerController.getTrainerBatches(id);
          
        assertEquals(response.getStatusCodeValue(), HttpStatus.SC_OK);
 
    }
       
    @AfterEach
    void tearDown() {
    }
        
}
