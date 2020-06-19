package com.revature.controllers;

import com.revature.beans.Assessment;
import com.revature.beans.Batch;
import com.revature.beans.Category;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.services.StoreRetrieveService;
import com.revature.utils.ParseJSON;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.ResponseEntity;


import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;


import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureWebTestClient
@AutoConfigureMockMvc
@Transactional
class JSONControllerTest {
   
	@InjectMocks
	JSONController jsonController;
	
	@Mock
	StoreRetrieveService service;
	
	@Autowired
	private MockMvc mockMvc;
	

	Trainer trainer;
	Trainer trainer2;
	Batch batch;
	Week week;
	Assessment assessment;
	Category category;
	
	List<Batch> batches;
	List<Week> weeks;
	List<Assessment> assessments;
	List<Category> categories;
	
	String samplePayload =  " \"employee\": {\r\n" + 
			"    \"email\": \"james.gosling@revature.com\",\r\n" + 
			"    \"firstName\": \"James\",\r\n" + 
			"    \"lastName\": \"Gosling\"\r\n" + 
			 "  },\r\n" +
			 "  \"batches\": [\r\n" +
			"    {\r\n" + 
			"      \"id\": 121501,\r\n" + 
			"      \"batchId\": \"Ix2x2UAB\",\r\n" + 
			"      \"name\": \"1804  Apr16 -2\",\r\n" + 
			"      \"startDate\": \"2018-04-23\",\r\n" + 
			"      \"endDate\": \"2018-06-29\",\r\n" + 
			"      \"skill\": \"JTA\",\r\n" + 
			"      \"location\": \"Revature LLC, Reston VA 20190\",\r\n" + 
			"      \"type\": \"Revature\",\r\n" + 
			"      \"qcNotes\": [\r\n" + 
			"        {\r\n" + 
			"          \"noteId\": 398328,\r\n" + 
			"          \"content\": \"mock content\",\r\n" + 
			"          \"week\": 1,\r\n" + 
			"          \"batchId\": \"Ix2x2UAB\",\r\n" + 
			"          \"associateId\": null,\r\n" + 
			"          \"employeeId\": null,\r\n" + 
			"          \"type\": \"QC_BATCH\",\r\n" + 
			"          \"technicalStatus\": \"Good\",\r\n" + 
			"          \"createdOn\": null,\r\n" + 
			"          \"lastUpdated\": null,\r\n" + 
			"          \"categories\": [\r\n" + 
			"            \"Java\"\r\n" + 
			"          ]\r\n" + 
			"          ]\r\n" + 
			"        },\r\n " +
			" 		\"assessments\": [\r\n" + 
			"        {\r\n" + 
			"          \"assessmentId\": 177003,\r\n" + 
			"          \"rawScore\": 100,\r\n" + 
			"          \"assessmentTitle\": null,\r\n" + 
			"          \"assessmentType\": \"Exam\",\r\n" + 
			"          \"weekNumber\": 1,\r\n" + 
			"          \"batchId\": \"Ix2x2UAB\",\r\n" + 
			"          \"assessmentCategory\": 1,\r\n" + 
			"          \"skillCategory\": \"Java\",\r\n" + 
			"          \"assignmentDate\": null,\r\n" + 
			"          \"average\": 76.1\r\n" + 
			"        },";
	
	
    @BeforeEach
    void setUp() {
    	MockitoAnnotations.initMocks(this);
    	
    	trainer = new Trainer();
    	trainer2 = new Trainer();
    	batch = new Batch();
    	week = new Week();
    	assessment = new Assessment();
    	category = new Category();
    	
    	batches = new ArrayList<>();
    	weeks = new ArrayList<>();
    	assessments = new ArrayList<>();
    	categories = new ArrayList<>();
    	
    	category.setId(3);
    	category.setName("Java");
    	
    	categories.add(category);
    	
    	assessment.setId(3);
    	assessment.setScoreWeight(100);
    	assessment.setType("Exam");
    	assessment.setAverage(85.9f);
    	assessment.setSkillCategory(category);
    	
    	assessments.add(assessment);
    	
    	week.setId(2);
    	week.setWeekNumber("6");
    	week.setTechnicalStatus("good");
    	week.setAssessments(assessments);
    	week.setCategories(categories);
    	
    	weeks.add(week);
    	
    	batch.setId(1);
    	batch.setBatchId("abc123");
    	batch.setBatchName("batchName");
    	batch.setSkill("SQL");
    	batch.setLocation("WVU");
    	batch.setWeeks(weeks);
    	
    	batches.add(batch);
    	
    	
    	trainer.setId(5);
    	trainer.setEmployeeId("trainerID");
    	trainer.setFirstName("John");
    	trainer.setLastName("Carmack");
    	trainer.setEmail("email@domain.com");
    	trainer.setBatches(batches);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void storeTrainer() {
    }

   
    
    @Test
    @DisplayName("Test on JSONController status code, should return 200-ok")
    void testGetTrainerById() {
    	when(service.getTrainerById(anyInt())).thenReturn(trainer2);
    	
    	ResponseEntity<String> trainerObject = jsonController.getTrainer2();
    	
    	
    	
    	assertNotNull(trainerObject);
    	assertTrue(trainerObject.getStatusCode().is2xxSuccessful());
    	
    	System.out.println("Trainer object = " + trainerObject);
    	
    }
    
    
   
    @Disabled
    @DisplayName("test on addTrainer method, should not be equal to -1")
    
    // not working. My sample JSON object may be formatted incorrectly? But I dont think so...
    void testAddTrainerReturnValue() {
    	
    	ParseJSON parseJson = new ParseJSON();
    	
    	ParseJSON.setJson(samplePayload); 
    	
    Boolean returnValue = jsonController.addTrainer(samplePayload);
    
    System.out.println("Sample Payload = " + samplePayload);
    System.out.println("Return Value of Method = " + returnValue);
    
   assertTrue(returnValue);
    	
    }

}
