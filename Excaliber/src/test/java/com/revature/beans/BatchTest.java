package com.revature.beans;





import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;


class BatchTest {
	
	Batch batch;

    @BeforeEach
    void setUp() {
    	
    	batch = new  Batch();
    	
    	batch.setId(5);
    	batch.setBatchId("abc123");
    	batch.setBatchName("batch 1");
//    	batch.setDate();
//    	batch.setTime();
    	batch.setSkill("JTA");
    	batch.setLocation("Revature LLC, Reston VA 20190");
    	batch.setTrainerId(1);
    	
    	
    }

    @AfterEach
    void tearDown() {
    	
    	batch.setId(0);
    	batch.setBatchId("");
    	batch.setBatchName("");
//    	batch.setDate();
//    	batch.setTime();
    	batch.setSkill("");
    	batch.setLocation("");
    	batch.setTrainerId(0);
    	batch.setWeeks(null);
    }

    @Test
    @DisplayName("testing get batchName with pre-set value of batch 1")
    void getBatchName() {
    	
    	String expected = "batch 1";
    	String actual = batch.getBatchName();
    	
    	assertTrue(expected.equals(actual), "Expected = " + expected + "Actual = " + actual);
    	
    	
    }

    @Test
    @DisplayName("testing set trainerID with a set id of 3")
    void setTrainerId() {
    	
    	batch.setTrainerId(3);
    	
    	int expected = 3;
    	int actual = batch.getTrainerId();
    	
    	assertTrue(expected == actual, "Expected = " + expected + "Actual = " + actual);
    	
    }

    @Test
    @DisplayName("testing get Location with a pre-set value of Revature LLC, Reston VA 20190 ")
    void getLocation() {
    	
    	String expected = "Revature LLC, Reston VA 20190";
    	String actual = batch.getLocation();
    	
    	assertTrue(expected.equals(actual), "Expected = " + expected + "Actual = " + actual);
    	
    }

   
    @Test
    @DisplayName("testing get Weeks with a pre-set List of weeks ")
    void getAndSetWeeks() {
    	
    	// For the sake of time, I am combining the tests for get, and set
    	// generally these should be separate tests
    	
    	Week testWeek = new Week();
    	List<Week> weeks = new ArrayList<Week>();
    	
    	
    	testWeek.setId(69);
    	testWeek.setBatchId("cba321");
    	testWeek.setTechnicalStatus("good");
    	testWeek.setWeekNumber("B");
    	
    	weeks.add(testWeek);
    	
    	int expectedId = 69;
    	String expectedBatchId = "cba321";
    	String expectedTechnicalStatus = "good";
    	String expectedWeekNumber = "B";
    	
    	int actualId = weeks.get(0).getId();
    	String actualBatchId = weeks.get(0).getBatchId();
    	String actualTechnicalStatus = weeks.get(0).getTechnicalStatus();
    	String actualWeekNumber = weeks.get(0).getWeekNumber();
    	

    	
    	assertAll(
    			
    			()-> {assertEquals(expectedId, actualId, "ExpectedId = " + expectedId + " ActualId = " + actualId );},
    			()-> {assertEquals(expectedBatchId, actualBatchId,  " ExpectedBatchId = " + expectedBatchId + " ActualBatchId = " + actualBatchId);},
    			()-> {assertEquals(expectedTechnicalStatus, actualTechnicalStatus,  " ExpectedTechnicalStatus - " + expectedTechnicalStatus + " ActualTechnicalStatus = " + actualTechnicalStatus);},
    			()-> {assertEquals(expectedWeekNumber, actualWeekNumber, "ExpectedWeekNumber = " + expectedWeekNumber + " ActualWeekNumber = " + actualWeekNumber);}
    			
    			);
    	
    }
    

    @Test
    @DisplayName("testing set batch Id with a value of 1")
    void setBatchId() {
    	
    	batch.setId(1);
    	
    	int expected = 1;
    	int actual = batch.getId();
    	
    	assertEquals(expected, actual, "Expected Id = " + expected + " Actual ID = " + actual);
    	
    	
    }

    @Test
    @DisplayName("testing get skill with a pre-set value of JTA")
    void getSkill() {
    	
    	String expected = "JTA";
    	String actual = batch.getSkill();
    	
    	assertEquals(expected, actual, "Expected Id = " + expected + " Actual ID = " + actual);
    }

    @Test
    @DisplayName("testing get trainer Id with pre-set value of 1")
    void getTrainerId() {
    	
    	int expected = 1;
    	int actual = batch.getTrainerId();
    	
    	assertEquals(expected, actual, "Expected Id = " + expected + " Actual ID = " + actual);
    	
    	
    }

   
    // these fields have been excluded. 
 //-------------------------------------   
    @Test
    void setEndDate() {
    }
    @Test
    void getStartDate() {
    }

    @Test
    void setStartDate() {
    }
    @Test
    void getEndDate() {
    }
 //-------------------------------------   
    
    
    @Test
    @DisplayName("testing set id with a value of 9")
    void setId() {
    	
    	batch.setId(9);
    	
    	int expected = 9;
    	int actual = batch.getId();
    	
    	assertEquals(expected, actual, "Expected Id = " + expected + " Actual ID = " + actual);
    	
    }

    @Test
    @DisplayName("testing set Skill with value Java")
    void setSkill() {
    	
    	batch.setSkill("Java");
    	
    	String expected = "Java";
    	String actual = batch.getSkill();
    	
    	assertEquals(expected, actual, "Expected Id = " + expected + " Actual ID = " + actual);
    	
    }

    @Test
    @DisplayName("testing get Id with pre-set value of 5")
    void getId() {
    	
    	int expected = 5;
    	int actual = batch.getId();
    	
    	assertEquals(expected, actual, "Expected Id = " + expected + " Actual ID = " + actual);
    }

   

    @Test
    @DisplayName("testing getBatchId with pre-set value of abc123")
    void getBatchId() {
    	
    	String expected = "abc123";
    	String actual = batch.getBatchId();
    	
    	assertEquals(expected, actual, "Expected Id = " + expected + " Actual ID = " + actual);
    }

    @Test
    @DisplayName("testing set batch name with value of batch 762")
    void setBatchName() {
    	
    	batch.setBatchName("batch 762");
    	
    	String expected = "batch 762";
    	String actual = batch.getBatchName();
    	
    	assertEquals(expected, actual, "Expected Id = " + expected + " Actual ID = " + actual);
    }

    @Test
    @DisplayName("testing set location with value of Revature LLC, WVU 99999")
    void setLocation() {
    	
    	batch.setLocation("Revature LLC, WVU 99999");
    	
    	String expected = "Revature LLC, WVU 99999";
    	String actual = batch.getLocation();
    	
    	assertEquals(expected, actual, "Expected Id = " + expected + " Actual ID = " + actual);
    }
}
