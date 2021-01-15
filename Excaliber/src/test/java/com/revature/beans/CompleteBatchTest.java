package com.revature.beans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.*;
public class CompleteBatchTest {
	
	CompleteBatch cBatch;
	
	  @BeforeEach
	    void setUp() {
	    	
		  cBatch= new CompleteBatch();
		  cBatch.setBatchId("5");
		  cBatch.setCurrentWeek(5);
		  cBatch.setEndDate("01/12/2021");
		  cBatch.setId(1);
		  cBatch.setName("Sierra's Batch");
		  cBatch.setLocation("New York");
		  cBatch.setSkill("SpringBoot");
		  cBatch.setStartDate("11/09/2020");
		  cBatch.setType("Online");
		  Set<Object> assesements= new HashSet<>();
		  assesements.add("Hello");
		  assesements.add("HelloWorld");
		  assesements.add("HelloSpring");
		  
		  cBatch.setAssessments(assesements);

		  Set<Object> qCNotes= new HashSet<>();
		  qCNotes.add("Note1");
		  qCNotes.add("Note2");
		  qCNotes.add("Note3");
		  cBatch.setQCNotes(qCNotes);
		  
	    }
	  @AfterEach
	    void tearDown() {
	    	
	    	cBatch.setAssessments(null);
	    	cBatch.setBatchId("");
	    	cBatch.setId(0);
	    	cBatch.setCurrentWeek(0);
	    	cBatch.setEndDate("");
	    	cBatch.setStartDate("");
	    	cBatch.setLocation("");
	    	
	    }
	

}
