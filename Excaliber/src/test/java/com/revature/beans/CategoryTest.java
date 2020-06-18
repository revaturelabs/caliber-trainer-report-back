package com.revature.beans;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
