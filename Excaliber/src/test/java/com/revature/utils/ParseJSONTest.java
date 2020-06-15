package com.revature.utils;

import org.junit.jupiter.api.Test;

import static com.revature.utils.ParseJSON.*;
import static org.junit.jupiter.api.Assertions.*;

class ParseJSONTest {


    @Test
    public void testReadDataFromFileTrue() {
        // file is there should return true
        String fileName = "data.json";
        assertTrue(readDataFromFile(fileName));
    }


    @Test
    public void testReadDataFromFileFalse() {
        // should return false because file is not there
        String fileName = "noFile.json";

        assertThrows(NullPointerException.class,
                () -> {
                    assertFalse(readDataFromFile(fileName)); // throws NullPointerException
                });

    }

    // testing setBatchData
    @Test
    public void testSetBatchDataNull() {
        String fileName = "data.json";
        readDataFromFile(fileName);
        assertNotNull(setBatchData());
        assertEquals(4, setBatchData().size());
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
    public void testSetTrainer() {
        String fileName = "data.json";
        readDataFromFile(fileName);
        assertNotNull(setTrainer());
    }

    @Test
    public void testSetTrainerAssertionError() {
        assertThrows(AssertionError.class,
                () -> {
                    assertNull(setTrainer()); // throws AssertionError because file is not set
                });
    }

    // testing setWeek
//
//    @Test
//    public void testSetWeek() {
//        String fileName = "data.json";
//        readDataFromFile(fileName);
//        assertNotNull(setWeek());
//        assertEquals(40, setWeek().size());
//    }
//
//    @Test
//    public void testSetWeekAssertionError() {
//        assertThrows(AssertionError.class,
//                () -> {
//                    assertNull(setWeek()); // throws AssertionError because file is not set
//                });
//    }

    // testing setAssessment

    @Test
    public void testSetAssessment() {
        String fileName = "data.json";
        readDataFromFile(fileName);
        assertNotNull(setAssessment());
        assertEquals(57, setAssessment().size());
    }

    @Test
    public void testSetAssessmentAssertionError() {
        assertThrows(AssertionError.class,
                () -> {
                    assertNull(setAssessment()); // throws AssertionError because file is not set
                });
    }
}
