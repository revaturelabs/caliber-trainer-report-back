package com.revature.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QCTSScoreTest {
	QCTSScore score;
	
	@BeforeEach
	void setUp() {
		
		score = new QCTSScore();
		score.setGood(3.0d);
		score.setAverage(2.0d);
		score.setPoor(0.0d);
		score.setSuperstar(0.0d);
		score.setAvgGood(60.0d);
		score.setAvgAverage(40.0d);
		score.setAvgPoor(0.0d);
		score.setAvgSuperstar(0.0d);
		
	}
	
	@AfterEach
	void tearDown() {
		
		score.setGood(0.0d);
		score.setAverage(0.0d);
		score.setPoor(0.0d);
		score.setSuperstar(0.0d);
		score.setAvgGood(0.0d);
		score.setAvgAverage(0.0d);
		score.setAvgPoor(0.0d);
		score.setAvgSuperstar(0.0d);
		
	}
	
	@Test
	@DisplayName("testing get Good with value of 3")
	public void getGood() {
		Double expected = 3.0d;
		Double actual = score.getGood();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("testing set Good with value of 5")
	public void setGood() {
		Double expected = 5.0d;
		score.setGood(5.0d);
		Double actual = score.getGood();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("testing get Average with value of 2")
	public void getAverage() {
		Double expected = 2.0d;
		Double actual = score.getAverage();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("testing set Average with value of 3")
	public void setAverage() {
		Double expected = 3.0d;
		score.setAverage(3.0d);
		Double actual = score.getAverage();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("testing get Poor with value of 0")
	public void getPoor() {
		Double expected = 0.0d;
		Double actual = score.getPoor();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("testing set Poor with value of 1")
	public void setPoor() {
		Double expected = 1.0d;
		score.setPoor(1.0d);
		Double actual = score.getPoor();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("testing get Superstar with value of 0")
	public void getSuperstar() {
		Double expected = 0.0d;
		Double actual = score.getSuperstar();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("testing set Superstar with value of 4")
	public void setSuperstar() {
		Double expected = 4.0d;
		score.setSuperstar(4.0d);
		Double actual = score.getSuperstar();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("testing get Average Good with value of 60.0")
	public void getAvgGood() {
		Double expected = 60.0d;
		Double actual = score.getAvgGood();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("testing set Average Good with value of 80.0")
	public void setAvgGood() {
		Double expected = 80.0d;
		score.setAvgGood(80.0d);
		Double actual = score.getAvgGood();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("testing get Average Average with value of 40")
	public void getAvgAverage() {
		Double expected = 40.0d;
		Double actual = score.getAvgAverage();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("testing set average average with value of 0")
	public void setAvgAverage() {
		Double expected = 0.0d;
		score.setAvgAverage(0.0d);
		Double actual = score.getAvgAverage();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("testing set Average Poor with value of 60.0")
	public void setAvgPoor() {
		Double expected = 60.0d;
		score.setAvgPoor(60.d);
		Double actual = score.getAvgPoor();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("testing get Average Poor with value of 0.0")
	public void getAvgPoor() {
		Double expected = 0.0d;
		Double actual = score.getAvgPoor();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("testing get average superstar with value of 0")
	public void getAvgSuperstar() {
		Double expected = 0.0d;
		Double actual = score.getAvgSuperstar();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("testing set Average superstar with value of 60.0")
	public void setAvgSuperstar() {
		Double expected = 60.0d;
		score.setAvgSuperstar(60.0d);
		Double actual = score.getAvgSuperstar();
		assertEquals(expected,actual);
	}
}
