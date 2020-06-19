package com.revature.services;

import org.junit.jupiter.api.AfterEach;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.transaction.annotation.Transactional;


import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Assessment;
import com.revature.beans.Batch;
import com.revature.beans.Category;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.data.TrainerDAO;


/**
 * The type Store retrieve service test.
 */


@SpringBootTest
@AutoConfigureWebTestClient
@Transactional
class StoreRetrieveServiceTest {
	
	@InjectMocks
	StoreRetrieveService service;
	
	@Mock
	TrainerDAO tDao;
	

	
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

    /**
     * Sets up.
     */
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

    /**
     * Tear down.
     */
    @AfterEach
    void tearDown() {
    }

    /**
     * Add category.
     */
    @Test
    void addCategory() {
    	

    }

    /**
     * Add assessment.
     */
    @Test
    void addAssessment() {
    }

    /**
     * Add week.
     */
    @Test
    void addWeek() {
    }

    /**
     * Add batch.
     */
    @Test
    void addBatch() {
    }

    /**
     * Add trainer.
     */
    @Test
    void addTrainer() {
    }

    /**
     * Add entire trainer.
     */
    @Test
    void addEntireTrainer() {
    	
    	when(service.addEntireTrainer(trainer)).thenReturn(trainer);
    	
    	service.addEntireTrainer(trainer);
    	
    	int expected = 5;
    	int actual = trainer.getTrainerId();
    	
    	String expectedTechStat = "good";
    	String actualTechStat = week.getTechnicalStatus();
    	
    	assertAll(
    			()->{assertEquals(expected, actual, "Expected = " + expected + "Actual = " + actual);},
    			()->{assertEquals(expectedTechStat, actualTechStat, "Expected = " + expected + "Actual = " + actual);}
    			);
    	
    }

    /**
     * Gets trainer by id.
     */
    
    @Disabled
    void getTrainerById() {
    	
    	int trainerId = 1;
    	
    	
    	Trainer trainer = service.getTrainerById(trainerId);
    	
    	assertNotNull(trainer);
    	
    	
    	
    }
}
