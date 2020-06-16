package com.revature.beans;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;


class CategoryTest {
	
	Category category;

    @BeforeEach
    void setUp() {
    	category = new Category();
    	
    	category.setId(1);
    	category.setName("REST");
    }

    @AfterEach
    void tearDown() {
    	category.setId(0);
    	category.setName("");
    }

    @Test
    @DisplayName("testing get Name with preset name REST")
    void getName() {
    	
    	String expected = "REST";
    	String actual = category.getName();
    	
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
    	
    }

    @Test
    @DisplayName("testing get Id with pre-set value of 1")
    void getId() {
    	
    	int expected = 1;
    	int actual = category.getId();
    	
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
    	
    }

    @Test
    @DisplayName("testing set Id with a value of 5")
    void setId() {
    	
    	category.setId(5);
    	
    	int expected = 5;
    	int actual = category.getId();
    	
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
    	
    }

    @Test
    @DisplayName("testing set Name with value of Hibernate")
    void setName() {
    	
    	category.setName("Hibernate");
    	
    	String expected = "Hibernate";
    	String actual = category.getName();
    	
    	assertEquals(expected, actual, "Expected = " + expected + " Actual = " + actual);
    	
    }
}
