package com.revature.utils;

import com.revature.beans.*;
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

    /**
     * Gets all Batch object from the JSON
     *
     * @return
     * @throws JSONException
     */
    private static JSONArray getBatchJSONObject() throws JSONException {
        return new JSONObject(json).getJSONArray("batches");
    }

    /**
     * Loads data from JSON object and creates a set of Batchs
     *
     * @return Set<Batch>
     */
    public static Set<Batch> setBatchData() {
        assert json != null;
        Set<Batch> batchSet = new HashSet();
        try {
            JSONArray batchsJSON = getBatchJSONObject();
            for (int i = 0; i < batchsJSON.length(); i++) {
                JSONObject obj = batchsJSON.getJSONObject(i);
                Batch batch = new Batch(
                        obj.getString("batchId"),
                        obj.getString("name"),
                        obj.getString("startDate"),
                        obj.getString("endDate"),
                        obj.getString("skill"),
                        obj.getString("location"));
                batch.setWeeks(setWeek(obj));
                batchSet.add(batch);
                System.out.println(batch);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return batchSet;
    }

    /**
     * @param batch
     * @return
     */
    protected static Set<Week> setWeek(JSONObject batch) {
        //TODO change for all batch
        assert json != null;
        Set<Week> weeks = new HashSet();
        try {
            JSONArray batchsJSON = getBatchJSONObject();

            // grab the qcNotes object
            JSONArray obj = batch.getJSONArray("qcNotes");
            for (int j = 0; j < obj.length(); j++) {
                // for each week in qcNotes object load data
                Week week = new Week(
                        obj.getJSONObject(j).getString("week"),
                        obj.getJSONObject(j).getString("technicalStatus")
                );

                week.setBatchId(batch.getString("batchId"));
                Set<Assessment> assessments = setAssessmentByBatch(batch);
                week.setAssessments(assessments);
                week.setCategories(setCategoriesByWeek(obj.getJSONObject(j)));
                weeks.add(week);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return weeks;
    }

    /**
     * @param week
     * @return
     * @throws JSONException
     */
    public static Set<Category> setCategoriesByWeek(JSONObject week) throws JSONException {
        // grab each categories qcNotes object
        JSONArray categories = week.getJSONArray("categories");
        Set<Category> setCategories = new HashSet();
        for (int k = 0; k < categories.length(); k++) {
            setCategories.add(new Category(categories.getString(k)));
        }
        return setCategories;
    }

    /**
     * @param batch
     * @return
     */
    protected static Set<Assessment> setAssessmentByBatch(JSONObject batch) {
        assert json != null;
        Set<Assessment> assessments = new HashSet();

        try {
            JSONArray batchsJSON = getBatchJSONObject();

            JSONArray obj = batch.getJSONArray("assessments");
            for (int i = 0; i < obj.length(); i++) {

                Assessment assessment = new Assessment(
                        Integer.valueOf(obj.getJSONObject(i).getString("rawScore")),
                        obj.getJSONObject(i).getString("assessmentType"),
                        Float.valueOf(obj.getJSONObject(i).getString("average"))
                );
                assessment.setSkillCategory(new Category(obj.getJSONObject(i).getString("skillCategory")));
                assessments.add(assessment);
            }


//            System.out.println(assessments);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return assessments;
    }

    /**
     * @return
     */
    protected static Set<Assessment> setAssessment() {
        assert json != null;
        Set<Assessment> assessments = new HashSet();

        try {
            JSONArray batchsJSON = getBatchJSONObject();
            for (int j = 0; j < batchsJSON.length(); j++) {
                JSONArray obj = batchsJSON.getJSONObject(j).getJSONArray("assessments");
                for (int i = 0; i < obj.length(); i++) {
                    assessments.add(new Assessment(
                            Integer.valueOf(obj.getJSONObject(i).getString("rawScore")),
                            obj.getJSONObject(i).getString("assessmentType"),
                            Float.valueOf(obj.getJSONObject(i).getString("average"))
                    ));
                }
            }

//            System.out.println(assessments);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return assessments;
    }

    /**
     * @return
     */
    public static Trainer setTrainer() {
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

    /**
     * @param fileName
     * @return
     */
    public static boolean readDataFromFile(String fileName) {

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

    /**
     * gets all the batch id from the JSON
     *
     * @return set of batch ids
     */
    public Set<String> getBatchIds() {
        assert json != null;
        Set<String> out = new HashSet();
        JSONArray batchsJSON = null;
        try {
            batchsJSON = getBatchJSONObject();
            for (int i = 0; i < batchsJSON.length(); i++) {
                out.add(batchsJSON.getJSONObject(i).getString("batchId"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return out;
    }
}

