package com.revature.utils;

import com.revature.beans.Assessment;
import com.revature.beans.Batch;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;

public class ParseJSON {
    private static String json;
    private static JSONObject obj;


    protected static Batch setBatchData() {
        assert json != null;
        try {
            JSONObject obj = new JSONObject(json).getJSONArray("batches").getJSONObject(0);
            Batch batch = new Batch(
                    obj.getString("batchId"),
                    obj.getString("name"),
                    obj.getString("startDate"),
                    obj.getString("endDate"),
                    obj.getString("skill"),
                    obj.getString("location"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected static Set<Week> setWeek() {
        //TODO change for all batch
        assert json != null;
        Set<Week> weeks = new HashSet();
        try {
            JSONArray obj = new JSONObject(json).getJSONArray("batches").getJSONObject(0).getJSONArray("qcNotes");
            for (int i = 0; i < obj.length(); i++) {
                weeks.add(new Week(obj.getJSONObject(i).getString("week"), obj.getJSONObject(i).getString("technicalStatus")));
            }
            System.out.println(weeks);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return weeks;
    }

    protected static Trainer setTrainer() {
        assert json != null;
        Trainer trainer = null;
        try {
            obj = new JSONObject(json).getJSONObject("employee");
            trainer = new Trainer(obj.get("firstName").toString(), obj.get("lastName").toString(),
                    obj.get("email").toString());
            return trainer;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return trainer;
    }

    protected static Set<Assessment> setAssessment() {
        assert json != null;
        Set<Assessment> assessments = new HashSet();
        try {
            JSONArray obj = new JSONObject(json).getJSONArray("batches").getJSONObject(0).getJSONArray("assessments");
            for (int i = 0; i < obj.length(); i++) {
                assessments.add(new Assessment(
                        Integer.valueOf(obj.getJSONObject(i).getString("rawScore")),
                        obj.getJSONObject(i).getString("assessmentType"),
                        Float.valueOf(obj.getJSONObject(i).getString("average")),
                        obj.getJSONObject(i).getString("skillCategory")
                ));
            }
            System.out.println(assessments);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return assessments;
    }


    protected static boolean readDataFromFile(String fileName) {

        ClassLoader classLoader = new ParseJSON().getClass().getClassLoader();

        File file = new File(classLoader.getResource(fileName).getFile());

        //File is found
        System.out.println("File Found : " + file.exists());

        try {
            json = new String(Files.readAllBytes(file.toPath()));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

