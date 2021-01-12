package com.revature.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.*;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;




/**
 * The type Parse json.
 */
public class ParseJSON {
    private static String json = "";

    private static final Logger log = Logger.getLogger(ParseJSON.class);

    /**
     * Gets all Batch object from the JSON
     *
     * @return JSONObject of the batchs
     * @throws JSONException if parsing ERORR
     */
    protected static JSONArray getBatchJSONObject() throws JSONException {
        return new JSONObject(json).getJSONArray("batches");
    }

    /**
     * Loads data from JSON object and creates a set of Batchs
     *
     * @return Set<Batch>   batch data
     */
    public static List<Batch> getBatch() {
        assert json != null;
        List<Batch> batchSet = new ArrayList<>();
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
                System.out.println("JSONObject" + obj);
                batch.setWeeks(getWeeks(obj));
                batchSet.add(batch);
            }

        } catch (JSONException e) {
            log.error(e.toString());

        }
        return batchSet;
    }

    /**
     * Gets week from JSON.
     *
     * @param batch the batch JSONObject
     * @return week weeks in the batch
     */
    protected static List<Week> getWeeks(JSONObject batch) {
        assert json != null;
        List<Week> weeks = new ArrayList<>();
        try {
            log.trace("Getting Week for Batch: " + batch.getString("batchId"));
            // grab the qcNotes object
            JSONArray obj = batch.getJSONArray("qcNotes");
            for (int j = 0; j < obj.length(); j++) {
                // for each week in qcNotes object load data
                //create a new week
                // Week(String weekNumber, String technicalStatus)
                Week week = new Week(
                        obj.getJSONObject(j).getString("week"),
                        obj.getJSONObject(j).getString("technicalStatus")
                );

                week.setBatchId(batch.getString("batchId"));
                log.trace("Week from JSON: " + week);
                // add assessments to the week
                List<Assessment> assessments = getAssessmentByBatch(batch, week);
                log.trace("Adding assessments to the week ... ");
                week.setAssessments(assessments);
                log.trace("Assessments adding to the week ");
                log.trace("Adding categories to the week ... ");
                week.setCategories(getCategoriesByWeek(obj.getJSONObject(j)));
                log.trace("Categories adding to the week ");
                weeks.add(week);
                log.trace("___________________________________");
            }

        } catch (JSONException e) {
            log.error(e.toString());
        }
        return weeks;
    }

    /**
     * Gets categories by week in JSON.
     *
     * @param week a week from JSONObject
     * @return categories list of categories in a week
     * @throws JSONException the json exception
     */
    protected static List<Category> getCategoriesByWeek(JSONObject week) throws JSONException {
        // grab each categories from qcNotes object
        log.trace("Getting categories for week number:  " + week.getString("week"));
        // grab each categories from qcNotes object
        JSONArray categories = week.getJSONArray("categories");
        List<Category> setCategories = new ArrayList<>();
        for (int k = 0; k < categories.length(); k++) {
            //Category(String name)
            Category category = new Category(categories.getString(k));
            setCategories.add(category);
            log.trace("Adding Category => " + category);
        }
        return setCategories;
    }

    /**
     * Sets assessment by batch from JSON
     *
     * @param batch the batch
     * @param week week object
     * @return assessment by batch
     */
    protected static List<Assessment> getAssessmentByBatch(JSONObject batch, Week week) {
        assert json != null;
        List<Assessment> assessments = new ArrayList<>();

        try {


            JSONArray obj = batch.getJSONArray("assessments");
            for (int i = 0; i < obj.length(); i++) {
                if (Integer.parseInt(week.getWeekNumber()) == Integer.parseInt(obj.getJSONObject(i).getString("weekNumber"))) {
                    Assessment assessment = new Assessment(
                            Integer.valueOf(obj.getJSONObject(i).getString("rawScore")),
                            obj.getJSONObject(i).getString("assessmentType"),
                            Float.valueOf(obj.getJSONObject(i).getString("average"))
                    );

                    assessment.setSkillCategory(new Category(obj.getJSONObject(i).getString("skillCategory")));
                    assessments.add(assessment);
                }
            }
        } catch (JSONException e) {
            log.error(e.toString());
        }
        return assessments;
    }

    /**
     * Gets assessment from JSON.
     *
     * @return assessment assessment
     */
    protected static List<Assessment> getAssessment() {
        assert json != null;
        List<Assessment> assessments = new ArrayList<>();

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

        } catch (JSONException e) {
            log.error(e.toString());
        }
        return assessments;
    }

    /**
     * Gets trainer from JSOn.
     *
     * @return trainer trainer
     */
    public static Trainer getTrainer() {
        JSONObject obj;
        log.debug("New JSON file set");
        // check if json is null
        assert json != null;

        Trainer trainer = null;
        try {
            obj = new JSONObject(json).getJSONObject("employee");
            log.trace("Trainer object found in JSON");
            trainer = new Trainer(obj.get("firstName").toString(), obj.get("lastName").toString(),
                    obj.get("email").toString());
            log.trace("Trainer object is now created");
        } catch (JSONException e) {
            log.error("Couldn't create Trainer object");
            log.error(e.toString());
        }
        log.debug("Trainer -> " + trainer);
        return trainer;
    }

    /**
     * Read data from file boolean.
     *
     * @param fileName the file name
     * @return boolean boolean
     */
    public static boolean readDataFromFile(String fileName) {

        ClassLoader classLoader = ParseJSON.class.getClassLoader();
        File file;
        try {
            file = new File(classLoader.getResource(fileName).getFile());
            //File is found
            log.debug("File Found: " + file.exists());
            try {
                json = new String(Files.readAllBytes(file.toPath()));
                return true;
            } catch (IOException e) {
                log.error(e.toString());
            }
        } catch (NullPointerException e) {
            log.error(e.toString());
        }

        return false;
    }

    /**
     * Read data from file boolean.
     *
     * @param fileName the file name
     * @return boolean boolean
     */
    public static String readDataFromFileString(String fileName) {
        String out = "";
        ClassLoader classLoader = ParseJSON.class.getClassLoader();
        File file;
        try {
            file = new File(classLoader.getResource(fileName).getFile());
            //File is found
            log.debug("File Found: " + file.exists());
            try {
                out = new String(Files.readAllBytes(file.toPath()));
            } catch (IOException e) {
                log.error(e.toString());
            }
        } catch (NullPointerException e) {
            log.error(e.toString());
        }

        return out;
    }

    /**
     * Sets json to be parsed.
     *
     * @param json the json
     */
    public static void setJson(String json) {
        log.debug("New JSON file set");
        ParseJSON.json = json;
    }


    /**
     * gets all the batch id from the JSON
     *
     * @return set of batch ids
     */
    public List<String> getBatchIds() {
        log.debug("Calling getBatchIds");
        assert json != null;
        List<String> out = new ArrayList<>();
        JSONArray batchsJSON;
        try {
            batchsJSON = getBatchJSONObject();
            for (int i = 0; i < batchsJSON.length(); i++) {
                out.add(batchsJSON.getJSONObject(i).getString("batchId"));
            }
        } catch (JSONException e) {
            log.error(e.toString());
        }

        return out;
    }

    //better ParseJSON
    JSONAsClass jsonObject;

    //parsing with jackson
    public ParseJSON(String jsonString){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            jsonObject = objectMapper.readValue(jsonString, JSONAsClass.class);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Trainer getTrainerUsingJackson(){
        Trainer trainer = null;

        if(jsonObject != null){
            trainer = new Trainer(
                    jsonObject.employee.firstName,
                    jsonObject.employee.lastName,
                    jsonObject.employee.email
            );

            //create batch list
            List<Batch> batches = new ArrayList<>();
            Batch batch;
            for(BatchJSON b : jsonObject.batches){
                batch = new Batch(
                        b.batchId,
                        b.name,
                        b.startDate,
                        b.endDate,
                        b.skill,
                        b.location
                );

                //get the weeks
                List<Week> weeks = new ArrayList<>();
                Week w;
                for(QCNotesJSON qcjson : b.qcNotes){
                    w = new Week(qcjson.week, qcjson.technicalStatus);
                    w.setBatchId(b.batchId);

                    //correcting for null tech status weeks
                    if(qcjson.technicalStatus == null){
                        w.setTechnicalStatus("null");
                    }

                    List<Category> categories = new ArrayList<>();
                    Category cat;
                    for(String c : qcjson.categories){
                        cat = new Category(c);
                        categories.add(cat);
                    }
                    w.setCategories(categories);

                    //set the assessments for the week
                    List<Assessment> assessments = new ArrayList<>();
                    Assessment ass;
                    for(AssessmentJSON a : b.assessments){

                        //only add this assessment if it was part of the week
                        if(a.weekNumber != Integer.valueOf(w.getWeekNumber())){
                            continue;
                        }

                        ass = new Assessment(
                                a.rawScore,
                                a.assessmentType,
                                a.average
                        );
                        Category skillCat = new Category(a.skillCategory);
                        ass.setSkillCategory(skillCat);

                        assessments.add(ass);
                    }
                    w.setAssessments(assessments);
                    weeks.add(w);
                }
                batch.setWeeks(weeks);

                batches.add(batch);
            }
            trainer.setBatches(batches);
        }

        return trainer;
    }

    //Nested classes for easier JSON parsing with Jackson

    private static class JSONAsClass{
        public TrainerJSON employee;
        public BatchJSON[] batches;
    }

    private static class TrainerJSON{
        public String firstName;
        public String lastName;
        public String email;
    }

    private static class BatchJSON{
        public int id;
        public String batchId;
        public String name;
        public String startDate;
        public String endDate;
        public String skill;
        public String location;
        public String type;
        public QCNotesJSON[] qcNotes;
        public AssessmentJSON[] assessments;
    }

    private static class QCNotesJSON{
        public int noteId;
        public String content;
        public String week;
        public String batchId;
        public Integer associateId;//can be null
        public Integer employeeId;//can be null
        public String type;
        public String technicalStatus;
        public String createdOn;
        public String lastUpdated;
        public String[] categories;
    }

    private static class AssessmentJSON{
        public int assessmentId;
        public int rawScore;
        public String assessmentTitle;
        public String assessmentType;
        public int weekNumber;
        public String batchId;
        public int assessmentCategory;
        public String skillCategory;
        public String assignmentDate;
        public float average;
    }
}

