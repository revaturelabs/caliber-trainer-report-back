package com.revature.tables;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TechnicalStatusByWeekTest {

	TechnicalStatusByWeek tsbw = new TechnicalStatusByWeek();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    	tsbw = new TechnicalStatusByWeek();
    }

    @Test
	void getSuperstarCountTest() {
		tsbw.setSuperstarCount(5);
		assertEquals(tsbw.getSuperstarCount(),5);
    }
    
    @Test
    void getCategory() {
    }

    @Test
    void setCategory() {
    }

    @Test
    void getNullCount() {
    }

    @Test
    void setNullCount() {
    }

    @Test
    void getPoorCount() {
    }

    @Test
    void setPoorCount() {
    }

    @Test
    void getAverageCount() {
    }

    @Test
    void setAverageCount() {
    }

    @Test
    void getGoodCount() {
    }

    @Test
    void setGoodCount() {
    }

    @Test
    void getSuperstarCount() {
    	
    	
    }

    @Test
    void getNullAvg() {
    }

    @Test
    void setNullAvg() {
    }

    @Test
    void getPoorAvg() {
    }

    @Test
    void setPoorAvg() {
    }

    @Test
    void getAverageAvg() {
    }

    @Test
    void setAverageAvg() {
    }

    @Test
    void getGoodAvg() {
    }

    @Test
    void setGoodAvg() {
    }

    @Test
    void getSuperstarAvg() {
    }

    @Test
    void setSuperstarAvg() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testToString() {
    }
}
