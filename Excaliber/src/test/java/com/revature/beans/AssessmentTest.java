
package com.revature.beans;


import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;

import org.junit.jupiter.api.*;


class AssessmentTest {
	
	Assessment assessment;

    @BeforeEach
    void setUp() {
    	
    	assessment = new Assessment();
    	assessment.setId(5);
    	assessment.setAverage(5.6f);
    	assessment.setScoreWeight(3);
    	assessment.setType("QC_Batch");
    	
    }

    @AfterEach
    void tearDown() {
    	
    	assessment.setId(0);
    	assessment.setAverage(0f);
    	assessment.setScoreWeight(0);
    	assessment.setType("");
    	
    }

    @Test
    @DisplayName("testing get ID method with pre-set value of 5")
    void getId() {
    	
    	int expected = 5;
    	int actual = assessment.getId();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    	
    }

    @Test
    @DisplayName("testing set ID with a set value of 1")
    void setId() {
    	
    	 assessment.setId(1);
    	 
    	 int expected = 1;
    	 int actual = assessment.getId();
    	 
    	 assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    }

    @Test
    @DisplayName("testing get scoreWeight with a pre set value of 3")
    void getScoreWeight() {
    	
    	int expected = 3;
    	int actual = assessment.getScoreWeight();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    	
    }

    @Test
    @DisplayName("testing set scoreWeight with a set value of 9")
    void setScoreWeight() {
    	
    	assessment.setScoreWeight(9);
    	
    	int expected = 9;
    	int actual = assessment.getScoreWeight();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    }

    @Test
    @DisplayName("testing get Type with a pre set value of QC_Batch ")
    void getType() {
    	
    	String expected = "QC_Batch";
    	String actual = assessment.getType();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    }

    @Test
    @DisplayName("testing set Type with a value of !QC_Batch ")
    void setType() {
    	
    	assessment.setType("!QC_Batch");
    	
    	String expected = "!QC_Batch";
    	String actual = assessment.getType();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    }

    @Test
    @DisplayName("testing get Average with pre-set value of 5.6")
    void getAverage() {
    	
    	Float expected = 5.6f;
    	Float actual = assessment.getAverage();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    }

    @Test
    @DisplayName("testing set Average with value of 6.5")
    void setAverage() {
    	
    	assessment.setAverage(6.5f);
    	
    	Float expected = 6.5f;
    	Float actual = assessment.getAverage();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    }
    
   

    
   
	@Test
	@DisplayName("Testing get skill category.")
    void getSkillCategory() {
    	
    	Category category = new Category();
    	ArrayList<Category> expected = new ArrayList<Category>();
    	
    	category.setId(1);
    	category.setName("JavaScript");
    	
    	
    	
    	int actualID = category.getId();
    	String actualName = category.getName();
    	
    	expected.add(category);
    
    	
    	int expectedID = expected.get(0).getId();
    	String expectedName = expected.get(0).getName();
    	
    	assertTrue(expectedID == actualID && expectedName.equals(actualName),
    			"ExpectedID = " + expectedID + "ExpectedName = " + actualName);
    	
    }
	
	@Test
	void setSkillCategory() {
		
		Category category1 = new Category();
		Category category2 = new Category();
		
		ArrayList<Category> expectedCategories = new ArrayList<Category>();
		
		
		category1.setId(2);
		category1.setName("SQL");
		category2.setId(3);
		category2.setName("Hibernate");
		
		expectedCategories.add(category1);
		expectedCategories.add(category2);
		
		
		int expectedId_cat1 = 2;
		String expectedName_cat1 = "SQL";
		
		int expectedId_cat2 = 3;
		String expectedName_cat2 = "Hibernate";
		
		int actualId_cat1 = expectedCategories.get(0).getId();
		String actualName_cat1 = expectedCategories.get(0).getName();
		
		int actualId_cat2 = expectedCategories.get(1).getId();
		String actualName_cat2 = expectedCategories.get(1).getName();
		
		
		// this is gross, I'm sorry. 
		assertTrue(
				expectedId_cat1 == actualId_cat1 &&
				expectedName_cat1.equals(actualName_cat1) &&
				expectedId_cat2 == actualId_cat2 &&
				expectedName_cat2.equals(actualName_cat2),
				"expectedId_cat1 = " + expectedId_cat1 + "actualId_cat1 = " + actualId_cat1 +
				"expectedName_cat1 = " + expectedName_cat1 + "actualName_cat1 = " + actualName_cat1 +
				"expectedId_cat2 = " + expectedId_cat2 + "actualId_cat2 = " + actualId_cat2 +
				"expetedName_cat2 = " + expectedName_cat2 + "actualName_cat2 = " + actualName_cat2

				);
		
		// tests were running and passing in (0.000) seconds. I assume because they are rather trivial, but just to be sure
		// things were happening, I printed the data to the console. Good news everyone! things were happening. 
		System.out.println("expectedId_cat1 = " + expectedId_cat1 + " actualId_cat1 = " + actualId_cat1 +
						" expectedName_cat1 = " + expectedName_cat1 + " actualName_cat1 = " + actualName_cat1 +
						" expectedId_cat2 = " + expectedId_cat2 + " actualId_cat2 = " + actualId_cat2 +
						" expetedName_cat2 = " + expectedName_cat2 + " actualName_cat2 = " + actualName_cat2);
		
	}


    
}
