

package com.revature.utils;

import com.revature.beans.Batch;
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
        assertNotNull(getBatch());
        assertEquals(4, getBatch().size());

        for (Batch o : getBatch()) {
            System.out.println(o.getBatchId());
            System.out.println(o.getWeeks().size());
//            assertEquals(10, o.getWeeks().size());
        }

    }

    @Test
    public void testSetBatchDataAssertionError() {
        assertThrows(AssertionError.class,
                () -> {
                    assertNull(getBatch()); // throws AssertionError because file is not set
                });
    }

    // testing setTrainer

    @Test
    public void testSetTrainer() {
        String fileName = "data.json";
        readDataFromFile(fileName);
        assertNotNull(getTrainer());
    }

    @Test
    public void testSetTrainerAssertionError() {
        assertThrows(AssertionError.class,
                () -> {
                    assertNull(getTrainer()); // throws AssertionError because file is not set
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
        assertNotNull(getAssessment());
        assertEquals(57, getAssessment().size());
    }

    @Test
    public void testSetAssessmentAssertionError() {
        assertThrows(AssertionError.class,
                () -> {
                    assertNull(getAssessment()); // throws AssertionError because file is not set
                });
    }

//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    void getBatch() {
//    }
//
//    @Test
//    void getWeek() {
//    }
//
//    @Test
//    void getCategoriesByWeek() {
//    }
//
//    @Test
//    void getAssessmentByBatch() {
//    }
//
//    @Test
//    void getAssessment() {
//    }
//
//    @Test
//    void getTrainer() {
//    }
//
//    @Test
//    void readDataFromFile() {
//    }
//
//    @Test
//    void getBatchIds() {
//    }
//
//    @Test
//    void getJson() {
//    }
//
//    @Test
//    void setJson() {
//    }
}

