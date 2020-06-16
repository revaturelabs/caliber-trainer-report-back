package com.revature.beans;

import org.junit.jupiter.api.*;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;



class TrainerTest {
	
	Trainer trainer;

    @BeforeEach
    void setUp() {
    	
    	trainer = new Trainer();
    	
    	trainer.setId(2);
    	trainer.setFirstName("John");
    	trainer.setLastName("Carmack");
    	trainer.setEmail("email@domain.com");
    	trainer.setEmployeeId("trainer Id 123");
    	
    	
    }

    @AfterEach
    void tearDown() {
    	
    	trainer.setId(0);
    	trainer.setFirstName("");
    	trainer.setLastName("");
    	trainer.setEmail("");
    	trainer.setEmployeeId("");
    	
    }

    @Test
    @DisplayName("testing set Emploee Id with value of trainer id 321")
    void setEmployeeId() {
    	
    	trainer.setEmployeeId("trainer id 321");
    	
    	String expected = "trainer id 321";
    	String actual = trainer.getEmployeeId();
    	
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
    	
    	
    	
    }

    @Test
    @DisplayName("testing set first name with value of Alan")
    void setFirstName() {
    	
    	trainer.setFirstName("Alan");
    	
    	String expected = "Alan";
    	String actual = trainer.getFirstName();
    	
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
    }

    @Test
    @DisplayName("testing get Email with pre-set value of email@domain.com")
    void getEmail() {
    	
    	String expected = "email@domain.com";
    	String actual = trainer.getEmail();
    	
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
    	
    }

    @Test
    @DisplayName("testing get Emplyoee Id with pre-set id of trainer Id 123")
    void getEmployeeId() {
    	
    	String expected = "trainer Id 123";
    	String actual = trainer.getEmployeeId();
    	
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
    	
    }

    

    @Test
    @DisplayName("testing set email with value of test@domain.com")
    void setEmail() {
    	
    	trainer.setEmail("test@domain.com");
    	
    	String expected = "test@domain.com";
    	String actual = trainer.getEmail();
    
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
    }

    @Test
    @DisplayName("testing get last name with pre-set value of Carmack")
    void getLastName() {
    	
    	String expected = "Carmack";
    	String actual = trainer.getLastName();
    	
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
    }

    @Test
    @DisplayName("testing get first name with pre-set value of John")
    void getFirstName() {
    	
    	String expected = "John";
    	String actual = trainer.getFirstName();
    	
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
    	
    }

    @Test
    @DisplayName("testing set last name with value Turing")
    void setLastName() {
    	
    	trainer.setLastName("Turing");
    	
    	String expected = "Turing";
    	String actual = trainer.getLastName();
    	
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);

    	
    }

    @Test
    @DisplayName("testing get id with value of 2 ")
    void getId() {
    	
    	int expected = 2;
    	int actual = trainer.getTrainerId();
    	
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
    }

    

    @Test
    @DisplayName("testing set Id with value of 8")
    void setId() {
    	
    	trainer.setId(8);
    	
    	int expected = 8;
    	int actual = trainer.getTrainerId();
    	
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
    }

    
    
    @Test
    @DisplayName("testing get and set methods for Batches List")
    void setBatches() {
    	
    	Batch batch = new Batch();
    	List<Batch> batches = new ArrayList<Batch>();
    	
    	batch.setId(1);
    	batch.setBatchId("xxx 000");
    	batch.setBatchName("Batch 321");
    	batch.setSkill("SQL");
    	batch.setLocation("Revature LLC WVU");
    	
    	batches.add(batch);
    	
    	int expected_Id = 1;
    	String expected_BatchID = "xxx 000";
    	String expected_BatchName = "Batch 321";
    	String expected_BatchSkill = "SQL";
    	String expected_Location = "Revature LLC WVU";
    	
    	
    	int actual_Id = batches.get(0).getId();
    	String actual_BatchId = batches.get(0).getBatchId();
    	String actual_BatchName = batches.get(0).getBatchName();
    	String actual_BatchSkill = batches.get(0).getSkill();
    	String actual_Location = batches.get(0).getLocation();
    
    	
    	
    	
    	assertAll(
    			
    			()-> {assertEquals(expected_Id, actual_Id, "Expected ID = " + expected_Id + "Actual ID = " + actual_Id);},
    			()-> {assertEquals(expected_BatchID, actual_BatchId, "Expected_BatchId = " + expected_BatchID + " Actual_BatchId = " + actual_BatchId);},
    			()-> {assertEquals(expected_BatchName, actual_BatchName, "Expected_BatchName = " + expected_BatchName + " Actual_BatchName = " + actual_BatchName);},
    			()-> {assertEquals(expected_BatchSkill, actual_BatchSkill, "Expected_BatchSkill = " + expected_BatchSkill + " Actual_BatchSkill = " + actual_BatchSkill);},
    			()-> {assertEquals(expected_Location, actual_Location, "Expected_Location = " + expected_Location + " Actual_Location = " + actual_Location);}
    			
    			);
    	
    	
    	
    	
    }
}
