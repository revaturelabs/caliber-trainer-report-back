package com.revature.beans;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

public class BatchAssessmentTest {

	BatchAssessment batchAssessment;
	ArrayList<Float> assessments;
	ArrayList<Integer> weights;
	
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
    	
    	//batchAssessment.setBatchId("Ix2x2UAB");
    	batchAssessment.setBatchName("1804  Apr16 -2");
    	batchAssessment.setAssessments(assessments);
    	//batchAssessment.setWeights(weights);
    }

    @AfterEach
    void tearDown() {
    	//batchAssessment.setBatchId("");
    	batchAssessment.setBatchName("");
    	batchAssessment.setAssessments(null);
    	//batchAssessment.setWeights(null);
    }
    
//    @Test
//    @DisplayName("testing get Batch ID with preset ID Ix2x2UAB")
//    void getBatchId() {
//    	
//    	String expected = "Ix2x2UAB";
//    	String actual = batchAssessment.getBatchId();
//    	
//    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
//    	
//    }
    
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

    	ArrayList<Float> actual = batchAssessment.getAssessments();
    	
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
    	
    }
    
    @Test
    @DisplayName("testing set Batch Assessments with assessment values 99.2, 10.23, and 43.78")
    void setAssessments() {
    	
    	ArrayList<Float> test = new ArrayList<Float>();
    	
    	test.add((float) 71.23);
    	test.add((float) 90.5);
    	test.add((float) 61.34);
    	
    	List<Float> expected = new ArrayList<Float>();
    	
    	expected.add((float) 71.23);
    	expected.add((float) 90.5);
    	expected.add((float) 61.34);
    	
    	batchAssessment.setAssessments(test);

    	ArrayList<Float> actual = batchAssessment.getAssessments();
    	
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
    
//    @Test
//    @DisplayName("testing get Batch Weights with preset weights 100, 100, and 75")
//    void getWeights() {
//    	
//    	List<Integer> expected = new ArrayList<Integer>();
//    	
//    	expected.add(100);
//    	expected.add(100);
//    	expected.add(75);
//    	
//    	ArrayList<Integer> actual = batchAssessment.getWeights();
//    	
//    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
//    	
//    }
}
