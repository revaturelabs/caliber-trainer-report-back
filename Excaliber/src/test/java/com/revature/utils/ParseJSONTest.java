

package com.revature.utils;

import com.revature.beans.Batch;
import com.revature.beans.Category;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    public void testSetBatchDataSize4() {
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
        Trainer expectedTrainer = new Trainer("James", "Gosling", "james.gosling@revature.com");
        String fileName = "data.json";
        readDataFromFile(fileName);
        assertNotNull(getTrainer());
        assertEquals(expectedTrainer, getTrainer());
    }

    @Test
    public void testSetTrainerAssertionError() {
        assertThrows(AssertionError.class,
                () -> {
                    assertNull(getTrainer()); // throws AssertionError because file is not set
                });
    }

    // testing Week

    @Test
    public void testSetWeek() {
        String fileName = "data.json";
        readDataFromFile(fileName);
        try {
            JSONArray batchsJSON = getBatchJSONObject();
            for (int i = 0; i < batchsJSON.length(); i++) {
                List<Week> weeks = getWeeks(batchsJSON.getJSONObject(i));
                for (Week week : weeks) {
                    assertNotNull(week.getWeekNumber());
                    assertNotNull(week.getWeekNumber());
                    assertNotNull(week.getBatchId());
                    assertNotNull(week.getTechnicalStatus());
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // testing Category

    @Test
    void getCategoriesByWeekNotNull() {
        try {
            JSONArray batchsJSON = getBatchJSONObject();
            JSONArray obj = batchsJSON.getJSONObject(1).getJSONArray("qcNotes");
            assertNotNull(getCategoriesByWeek(obj.getJSONObject(1)));
            Category category = new Category("SQL");
            assertEquals(category, getCategoriesByWeek(obj.getJSONObject(1)).get(0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // testing Assessment

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


}

