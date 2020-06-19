package com.revature.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CategoryBatchesTest {
	BatchAssessment batchAssessment;
	BatchAssessment testBatchAssessment;
	ArrayList<Float> assessments;
	CategoryBatches categoryBatches;
	CategoryBatches testCategoryBatches;
	ArrayList<BatchAssessment> batchAssessments;
	ArrayList<BatchAssessment> testBatchAssessments;
	
	@BeforeEach
    void setUp() {
    	batchAssessment = new BatchAssessment();
    	assessments = new ArrayList<>();
    	batchAssessments = new ArrayList<>();
    	categoryBatches = new CategoryBatches();
    	
    	assessments.add((float) 71.23);
    	assessments.add((float) 90.5);
    	assessments.add((float) 61.34);
    	
    	batchAssessment.setBatchName("1804  Apr16 -2");
    	batchAssessment.setAssessments(assessments);
    	
    	batchAssessments.add(batchAssessment);
    	
    	categoryBatches.setCategory("Java");
    	categoryBatches.setBatchAssessments(batchAssessments);
    }

    @AfterEach
    void tearDown() {
    	batchAssessment.setBatchName("");
    	batchAssessment.setAssessments(null);
    	batchAssessments = null;
    	categoryBatches.setCategory("");
    	categoryBatches.setBatchAssessments(null);
    }
    
    @Test
    @DisplayName("testing get Category with preset category Java")
    void getCategory() {
    	
    	String expected = "Java";
    	String actual = categoryBatches.getCategory();
    	
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
    	
    }
    
    @Test
    @DisplayName("testing set Category with value SQL")
    void setCategory() {
    	categoryBatches.setCategory("SQL");
    	
    	String expected = "SQL";
    	String actual = categoryBatches.getCategory();
    	
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
    	
    }
    
    @Test
    @DisplayName("testing get Batch Assessments with preset assessments 71.23, 90.5, and 61.34 and name 1804  Apr16 -2")
    void getAssessments() {
    	
    	List<BatchAssessment> expected = new ArrayList<>();
    	batchAssessment = new BatchAssessment();
    	assessments = new ArrayList<>();
    	
    	assessments.add((float) 71.23);
    	assessments.add((float) 90.5);
    	assessments.add((float) 61.34);
    	
    	batchAssessment.setBatchName("1804  Apr16 -2");
    	batchAssessment.setAssessments(assessments);
    	
    	expected.add(batchAssessment);

    	List<BatchAssessment> actual = categoryBatches.getBatchAssessments();
    	
    	String leftSideName = expected.get(0).getBatchName();
    	String rightSideName = actual.get(0).getBatchName();
    	
    	assertEquals(leftSideName, rightSideName, "Expected = " + leftSideName + " Actual = " + rightSideName);

    	assertEquals(expected.get(0).getAssessments(), actual.get(0).getAssessments(), 
    			"Expected = " + expected.get(0).getAssessments() + " Actual = " + actual.get(0).getAssessments());
    }
    
    @Test
    @DisplayName("testing set Batch Assessments with batch assessment values 99.2, 10.23, and 43.78 and name 1901 Jan06 Other")
    void setAssessments() {
    	testBatchAssessment = new BatchAssessment();
    	testCategoryBatches = new CategoryBatches();
    	
    	ArrayList<Float> test = new ArrayList<>();
    	
    	test.add((float) 99.2);
    	test.add((float) 10.23);
    	test.add((float) 43.78);
    	
    	batchAssessment.setAssessments(test);
    	batchAssessment.setBatchName("1901 Jan06 Other");
    	
    	batchAssessments = new ArrayList<>();
    	batchAssessments.add(batchAssessment);
    	
    	categoryBatches.setBatchAssessments(batchAssessments);
    	
    	List<BatchAssessment> actual = categoryBatches.getBatchAssessments();
    	
    	List<Float> expectedArray = new ArrayList<>();
    	
    	expectedArray.add((float) 99.2);
    	expectedArray.add((float) 10.23);
    	expectedArray.add((float) 43.78);

    	testBatchAssessment.setAssessments(expectedArray);
    	testBatchAssessment.setBatchName("1901 Jan06 Other");
    	
    	testBatchAssessments = new ArrayList<>();
    	testBatchAssessments.add(testBatchAssessment);
    	
    	testCategoryBatches.setBatchAssessments(testBatchAssessments);
    	testCategoryBatches.setCategory("Java");
    	
    	List<BatchAssessment> expected = new ArrayList<>();
    	expected = testCategoryBatches.getBatchAssessments();
    	
    	assertEquals(expected.get(0).getBatchName(), actual.get(0).getBatchName(), "Expected = " + expected.get(0).getBatchName() + " Actual = " + actual.get(0).getBatchName());
    	
    	assertEquals(expected.get(0).getAssessments(), actual.get(0).getAssessments(), "Expected = " + expected + " Actual = " + actual);
    	
    }
}
