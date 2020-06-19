package com.revature.controllers;

import com.revature.beans.Assessment;
import com.revature.beans.Batch;
import com.revature.beans.Category;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.services.StoreRetrieveService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    @DisplayName("Unit test on getTrainerById, should return an object")
    void testNotNull() throws Exception {
    	when(service.getTrainerById(anyInt())).thenReturn(trainer);
    	
    	ResponseEntity trainerObject = jsonController.getTrainer2();
    	
    	assertNotNull(trainerObject);
    }
    @Test
    @DisplayName("Test on JSONController")
    void testGetTrainerById() {
    	//when(service.getTrainerById(anyInt())).thenReturn(trainer2);
    	
    	ResponseEntity<String> trainerObject = jsonController.getTrainer2();
    	
    	
    	
    	assertNotNull(trainerObject);
    	assertTrue(trainerObject.getStatusCode().is2xxSuccessful());
    	
    	System.out.println("Trainer object = " + trainer);
    	
    }
//    @Test
//    public void storeTrainerShouldReturnTrainer() throws Exception {
//        this.mockMvc.perform(get("/"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("Greetings from Spring Boot!")));
//    }
}
