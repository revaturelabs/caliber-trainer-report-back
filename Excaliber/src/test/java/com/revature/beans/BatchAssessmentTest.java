package com.revature.beans;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

public class BatchAssessmentTest {

	BatchAssessment batchAssessment;
	List<Float> assessments;
	List<Integer> weights;
	
	@BeforeEach
    void setUp() {
    	batchAssessment = new BatchAssessment();
    	assessments = new ArrayList<Float>();
    	weights = new ArrayList<Integer>();
    	
    	assessments.add((float) 71.23);
    	assessments.add((float) 90.5);
    	assessments.add((float) 61.34);
    	
    	weights.add(100);
    	weights.add(100);
    	weights.add(75);
    	
    	batchAssessment.setBatchName("1804  Apr16 -2");
    	batchAssessment.setAssessments(assessments);
    }

    @AfterEach
    void tearDown() {
    	batchAssessment.setBatchName("");
    	batchAssessment.setAssessments(null);
    }

    @Test
    @DisplayName("testing get Batch Name with preset name 1804  Apr16 -2")
    void getBatchName() {
    	
    	String expected = "1804  Apr16 -2";
    	String actual = batchAssessment.getBatchName();
    	
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
    	
    }
    
    @Test
    @DisplayName("testing get Batch Assessments with preset assessments 71.23, 90.5, and 61.34")
    void getAssessments() {
    	
    	List<Float> expected = new ArrayList<Float>();
    	
    	expected.add((float) 71.23);
    	expected.add((float) 90.5);
    	expected.add((float) 61.34);

    	List<Float> actual = batchAssessment.getAssessments();
    	
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
    	
    }
    
    @Test
    @DisplayName("testing set Batch Assessments with assessment values 99.2, 10.23, and 43.78")
    void setAssessments() {
    	
    	List<Float> test = new ArrayList<Float>();
    	
    	test.add((float) 71.23);
    	test.add((float) 90.5);
    	test.add((float) 61.34);
    	
    	List<Float> expected = new ArrayList<Float>();
    	
    	expected.add((float) 71.23);
    	expected.add((float) 90.5);
    	expected.add((float) 61.34);
    	
    	batchAssessment.setAssessments(test);

    	List<Float> actual = batchAssessment.getAssessments();
    	
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
    	
    }
    
    @Test
    @DisplayName("testing set Batch Name with value 1901 Jan06 Other")
    void setBatchName() {
    	
    	batchAssessment.setBatchName("1901 Jan06 Other");
    	
    	String expected = "1901 Jan06 Other";
    	String actual = batchAssessment.getBatchName();
    	
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
    	
    }
}
