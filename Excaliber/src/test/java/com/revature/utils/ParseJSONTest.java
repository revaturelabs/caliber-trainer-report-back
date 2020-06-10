package com.revature.utils;

import org.junit.jupiter.api.Test;

import static com.revature.utils.ParseJSON.*;
import static org.junit.jupiter.api.Assertions.*;

class ParseJSONTest {


    @Test
    public void testReadDataFromFileTrue(){
        // file is there should return true
        String fileName = "data.json";
        assertTrue(readDataFromFile(fileName));
    }


    @Test
    public void testReadDataFromFileFalse(){
        // should return false because file is not there
        String fileName = "noFile.json";

        assertThrows(NullPointerException.class,
                ()->{
                    assertFalse(readDataFromFile(fileName)); // throws NullPointerException
                });

    }

    // testing setBatchData
    @Test
    public void testSetBatchDataNull(){
        String fileName = "data.json";
        readDataFromFile(fileName);
        assertNull(setBatchData());
    }

    @Test
    public void testSetBatchDataAssertionError() {
        assertThrows(AssertionError.class,
                () -> {
                    assertNull(setBatchData()); // throws AssertionError because file is not set
                });
    }

    // testing setTrainer

    @Test
    public void testSetTrainerNull() {
        String fileName = "data.json";
        readDataFromFile(fileName);
        assertNotNull(setTrainer());
    }

    // testing setWeek

    @Test
    public void testSetWeekNull() {
        String fileName = "data.json";
        readDataFromFile(fileName);
        assertNotNull(setWeek());
    }

    // testing setAssessment

//    @Test
//    public void testSetAssessmentNull(){
//        String fileName = "data.json";
//        readDataFromFile(fileName);
//        assertNull(setAssessment());
//    }
}
