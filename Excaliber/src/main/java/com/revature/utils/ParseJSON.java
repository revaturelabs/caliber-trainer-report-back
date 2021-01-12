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

