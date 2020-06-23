package com.revature.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BatchTSCategoryTest {
	BatchTSCategory batchCategory;
	QCTSScore score;
	
	@BeforeEach
	void setUp() {
		batchCategory = new BatchTSCategory();
		score = new QCTSScore();
		score.setGood(1.0d);
		score.setAverage(0.0d);
		score.setPoor(0.0d);
		score.setSuperstar(0.0d);
		score.setAvgGood(100.0d);
		score.setAvgAverage(0.0d);
		score.setAvgPoor(0.0d);
		score.setAvgSuperstar(0.0d);
		batchCategory.setBatchName("1804  Apr16 -2");
		batchCategory.setScore(score);
	}
	
	@AfterEach
	void tearDown() {
		batchCategory.setBatchName("");
		score.setGood(0.0d);
		score.setAverage(0.0d);
		score.setPoor(0.0d);
		score.setSuperstar(0.0d);
		score.setAvgGood(0.0d);
		score.setAvgAverage(0.0d);
		score.setAvgPoor(0.0d);
		score.setAvgSuperstar(0.0d);
		batchCategory.setScore(score);
	}
	
	@Test
	@DisplayName("testing get batch name with pre-set value of 1804  Apr16 -2")
	public void getBatchName() {
		String expected = "1804  Apr16 -2";
		String actual = batchCategory.getBatchName();
		
		assertTrue(expected.contentEquals(actual),"Expected = " + expected + "Actual = " + actual );
	}
	
	@Test
	@DisplayName("testing set batch name with pre-set value of batch-2")
	public void setBatchName() {
		String expected = "batch-2";
		batchCategory.setBatchName("batch-2");
		String actual = batchCategory.getBatchName();
		
		assertTrue(expected.contentEquals(actual),"Expected = " + expected + "Actual = " + actual );
	}
	
	@Test
	@DisplayName("testing get score with pre-set value of 1804  Apr16 -2")
	public void getScore() {
		QCTSScore expected = new QCTSScore();
		expected.setGood(1.0d);
		expected.setAverage(0.0d);
		expected.setPoor(0.0d);
		expected.setSuperstar(0.0d);
		expected.setAvgGood(100.0d);
		expected.setAvgAverage(0.0d);
		expected.setAvgPoor(0.0d);
		expected.setAvgSuperstar(0.0d);
		QCTSScore actual = batchCategory.getScore();
		
		assertTrue(expected.equals(actual));
	}
	
	@Test
	@DisplayName("testing set score with pre-set value of 1804  Apr16 -2")
	public void setScore() {
		QCTSScore expected = new QCTSScore();
		expected.setGood(3.0d);
		expected.setAverage(0.0d);
		expected.setPoor(0.0d);
		expected.setSuperstar(0.0d);
		expected.setAvgGood(100.0d);
		expected.setAvgAverage(0.0d);
		expected.setAvgPoor(0.0d);
		expected.setAvgSuperstar(0.0d);
		
		batchCategory.setScore(expected);
		
		QCTSScore actual = batchCategory.getScore();
		
		assertTrue(expected.equals(actual));
	}
}
