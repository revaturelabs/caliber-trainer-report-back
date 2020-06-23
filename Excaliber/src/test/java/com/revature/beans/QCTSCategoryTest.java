package com.revature.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QCTSCategoryTest {
	QCTSCategory qcCategory;
	List<BatchTSCategory> batches;
	BatchTSCategory batch;
	QCTSScore score;
	@BeforeEach
	void setUp() {
		qcCategory = new QCTSCategory();
		batch = new BatchTSCategory();
		batch.setBatchName("1804  Apr16 -2");
		
		score = new QCTSScore();
		
		score.setGood(3.0d);
		score.setAverage(2.0d);
		score.setPoor(0.0d);
		score.setSuperstar(0.0d);
		score.setAvgGood(60.0d);
		score.setAvgAverage(40.0d);
		score.setAvgPoor(0.0d);
		score.setAvgSuperstar(0.0d);
		
		batch.setScore(score);
		
		batches = new ArrayList<>();
		
		batches.add(batch);
		qcCategory.setCategoryName("Java");
		qcCategory.setBatches(batches);
	}
	
	@AfterEach
	void tearDown() {
		qcCategory.setCategoryName("");
		qcCategory.setBatches(null);
	}
	
	@Test
	@DisplayName("Testing get category name with present skill category Java")
	public void getCategoryName() {
		String expected = "Java";
		String actual = qcCategory.getCategoryName();
		
		assertEquals(expected,actual, "Expected = " + expected + " Actual = " + actual);
	}
	
	@Test
	@DisplayName("Testing set category name with present skill category Java")
	public void setCategoryName() {
		String expected = "SQL";
		qcCategory.setCategoryName("SQL");
		String actual = qcCategory.getCategoryName();
		
		assertEquals(expected,actual, "Expected = " + expected + " Actual = " + actual);
	}
	
	@Test
	@DisplayName("Testing get batches with present skill category Java")
	public void getBatches() {
		List<BatchTSCategory> expected = new ArrayList<>();
		expected.add(batch);
		List<BatchTSCategory> actual = qcCategory.getBatches();
		
		assertEquals(expected,actual, "Expected = " + expected + " Actual = " + actual);
	}
	
	@Test
	@DisplayName("Testing set batches with present skill category Java")
	public void setBatches() {
		List<BatchTSCategory> expected = new ArrayList<>();
		expected.add(batch);
		
		qcCategory.setBatches(expected);
		
		List<BatchTSCategory> actual = qcCategory.getBatches();
		
		assertEquals(expected,actual, "Expected = " + expected + " Actual = " + actual);
	}
}
