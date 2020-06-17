package com.revature.beans;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;



class WeekTest {
	
	Week week;

    @BeforeEach
    void setUp() {
    	
    	week = new Week();
    	
    	week.setId(4);
    	week.setWeekNumber("A");
    	week.setBatchId("abc123");
    	week.setTechnicalStatus("Average");
    	
    }

    @AfterEach
    void tearDown() {
    	
    	week.setId(0);
    	week.setWeekNumber("");
    	week.setBatchId("");
    	week.setTechnicalStatus("");
    }

    @Test
    @DisplayName("testing set Id with value of 8")
    void setId() {
    	
    	week.setId(8);
    	
    	int expected = 8;
    	int actual = week.getId();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    	
    	
    }

    @Test
    @DisplayName("testing set and get funtions with  Assessment List ")
    void setAssessments() {
    	
    	Assessment assessment = new Assessment();
    	List<Assessment> assessments = new ArrayList<Assessment>();
    	
    	assessment.setId(2);
    	assessment.setScoreWeight(6);
    	assessment.setType("Exam");
    	assessment.setAverage(85.6f);
    	
    	assessments.add(assessment);
    	
    	int expected_Id = 2;
    	int expected_ScoreWeight = 6;
    	String expected_Type = "Exam";
    	Float expected_Average = 85.6f;
    	
    	int actual_Id = assessments.get(0).getId();
    	int actual_ScoreWeight = assessments.get(0).getScoreWeight();
    	String actual_Type = assessments.get(0).getType();
    	Float actual_Average = assessments.get(0).getAverage();
    	
    	
    	assertAll(
    			
    			()-> {assertTrue(expected_Id == actual_Id, "Expected_Id = " + expected_Id + " Actual_Id = " + actual_Id);},
    			()-> {assertTrue(expected_ScoreWeight == actual_ScoreWeight, "Expected_ScoreWeight = " + expected_ScoreWeight + " Actual_ScoreWeight = " + actual_ScoreWeight);},
    			()-> {assertTrue(expected_Type.equals(actual_Type), "Expected_Type = " + expected_Type + " Actual_Type = " + actual_Type );},
    			()-> {assertTrue(expected_Average.compareTo(actual_Average) == 0, "Expected_Average = " + expected_Average + " Actual_Avereage = " + actual_Average );}
    			
    			);
    	
    	
    }
    
    @Test
    @DisplayName("testing set and get functions with Category List")
    void setCategory() {
    	
    	Category category = new Category();
    	
    	List<Category> categories = new ArrayList<Category>();
    	
    	category.setId(7);
    	category.setName("SQL");
    	
    	categories.add(category);
    	
    	
    	int expected_Id = 7;
    	String expected_Name = "SQL";
    	
    	int actual_Id = categories.get(0).getId();
    	String actual_Name = categories.get(0).getName();
    	
    	
    	
    	
    	assertAll(
    			
    			()-> {assertTrue(expected_Id == actual_Id, "Expected ID = " + expected_Id + " Actual Id = " + actual_Id );},
    			()-> {assertTrue(expected_Name.equals(actual_Name), "Expected Name = " + expected_Name + " Actual_Name = " + actual_Name );}
    			
    			);
    }
    
}
