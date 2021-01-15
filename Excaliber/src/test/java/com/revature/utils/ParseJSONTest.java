

package com.revature.utils;

import com.revature.beans.Batch;
import com.revature.beans.Category;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.revature.utils.ParseJSON.*;
import static org.junit.jupiter.api.Assertions.*;
@Disabled
class ParseJSONTest {


    @Test
    public void testReadDataFromFileTrue() {
        // file is there should return true
        String fileName = "data.json";
        assertTrue(false);
    }


    @Test
    public void testReadDataFromFileFalse() {
        // should return false because file is not there
        String fileName = "noFile.json";

        assertThrows(NullPointerException.class,
                () -> {
                    assertFalse(true);
                });

    }

    // testing setBatchData
    @Test
    public void testSetBatchDataSize4() {
        String fileName = "data.json";
        assertNotNull(null);
        assertEquals(4, 0);

    }

    @Test
    public void testSetBatchDataAssertionError() {
        assertThrows(AssertionError.class,
                () -> {
                    assertNull(null);
                });
    }

    // testing setTrainer

    @Test
    public void testSetTrainer() {
        Trainer expectedTrainer = new Trainer("James", "Gosling", "james.gosling@revature.com");
        String fileName = "data.json";
        assertNotNull(null);
        assertEquals(expectedTrainer, null);
    }

    @Test
    public void testSetTrainerAssertionError() {
        assertThrows(AssertionError.class,
                () -> {
                    assertNull(null);
                });
    }

    // testing Week

    @Test
    public void testSetWeek() {

        assertTrue(false);
    }

    // testing Category

    @Test
    void getCategoriesByWeekNotNull() {

        assertTrue(false);
    }

    // testing Assessment

    @Test
    public void testSetAssessment() {

        assertTrue(false);
    }

    @Test
    public void testSetAssessmentAssertionError() {

        assertTrue(false);
    }


}

