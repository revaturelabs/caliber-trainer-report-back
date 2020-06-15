package com.revature.tables;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Assess scores by category all batches.
 */
public class AssessScoresByCategoryAllBatches {
    private List<Double> aScores; //assessment scores for each week
    private List<String> batchNames; //corresponding batch names
    private List<String> batchId;
    private String aType; //type of assessment: test, verbal, project etc.

    //add dates maybe?
    //private List<Date> startDates; //corresponding start dates


    /**
     * Instantiates a new Assess scores by category all batches.
     */
//two constructors
    public AssessScoresByCategoryAllBatches() {
        aScores = new ArrayList<Double>();
        batchNames = new ArrayList<String>();
        batchId = new ArrayList<String>();
        aType = "";
    }


    /**
     * Instantiates a new Assess scores by category all batches.
     *
     * @param aScores    the a scores
     * @param batchNames the batch names
     * @param batchId    the batch id
     * @param aType      the a type
     */
    public AssessScoresByCategoryAllBatches(List<Double> aScores, List<String> batchNames,
                                            List<String> batchId, String aType) {

        this.aScores = aScores;
        this.batchNames = batchNames;
        this.batchId = batchId;
        this.aType = aType;
    }

    /**
     * Gets scores.
     *
     * @return the scores
     */
//Getters and Setters
    public List<Double> getaScores() {
        return aScores;
    }

    /**
     * Sets scores.
     *
     * @param aScores the a scores
     */
    public void setaScores(List<Double> aScores) {
        this.aScores = aScores;
    }

    /**
     * Gets batch names.
     *
     * @return the batch names
     */
    public List<String> getBatchNames() {
        return batchNames;
    }

    /**
     * Sets batch names.
     *
     * @param batchNames the batch names
     */
    public void setBatchNames(List<String> batchNames) {
        this.batchNames = batchNames;
    }

    /**
     * Gets batch id.
     *
     * @return the batch id
     */
    public List<String> getBatchId() {
        return batchId;
    }

    /**
     * Sets batch id.
     *
     * @param batchId the batch id
     */
    public void setBatchId(List<String> batchId) {
        this.batchId = batchId;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getaType() {
        return aType;
    }

    /**
     * Sets type.
     *
     * @param aType the a type
     */
    public void setaType(String aType) {
        this.aType = aType;
    }


    @Override
    public String toString() {
        return "AssessScoresByCategoryAllBatches [aScores=" + aScores + ", batchNames=" + batchNames + ", batchId="
                + batchId + ", aType=" + aType + "]";
    }


}
