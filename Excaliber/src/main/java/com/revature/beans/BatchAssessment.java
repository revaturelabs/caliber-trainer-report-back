package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Batch assessment.
 */
//This bean does not need to go into the database. It is only used in the Java code.
public class BatchAssessment {

    private String batchName; //the batches name
    private List<Float> assessments; //the assessment score for that batch over all weeks

    /**
     * Instantiates a new Batch assessment.
     */
    public BatchAssessment() {
        batchName = "";
        assessments = new ArrayList<>();
    }


    /**
     * Gets batch name.
     *
     * @return the batch name
     */
    public String getBatchName() {
        return batchName;
    }

    /**
     * Sets batch name.
     *
     * @param batchName the batch name
     */
    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    /**
     * Gets assessments.
     *
     * @return the assessments
     */
    public List<Float> getAssessments() {
        return assessments;
    }

    /**
     * Sets assessments.
     *
     * @param assessments the assessments
     */
    public void setAssessments(List<Float> assessments) {
        this.assessments = assessments;
    }


    @Override
    public String toString() {
        return "BatchAssessment [batchName=" + batchName + ", assessments=" + assessments + "]";
    }
}
