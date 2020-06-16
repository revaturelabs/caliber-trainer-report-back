package com.revature.tables;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BatchAssessment;

/**
 * The type Assess scores by category all batches.
 */
public class AssessScoresByCategoryAllBatches {
	private List<BatchAssessment> batches; //the list of all of the batches with their assessment scores
    private String aType; //type of assessment: test, verbal, project etc.

    //add dates maybe?
    //private List<Date> startDates; //corresponding start dates


    /**
     * Instantiates a new Assess scores by category all batches.
     */
//two constructors
    public AssessScoresByCategoryAllBatches() {
    	batches = new ArrayList<BatchAssessment>();
        aType = "";
    }


    /**
     * Instantiates a new Assess scores by category all batches.
     *
     * @param batches	 the batches with scores attached
     * @param aType      the a type
     */
    public AssessScoresByCategoryAllBatches(List<BatchAssessment> batches, String aType) {
    	this.batches = batches;
    	this.aType = aType;
    }

//Getters and Setters
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
    
	public List<BatchAssessment> getBatches() {
		return batches;
	}

	public void setBatches(List<BatchAssessment> batches) {
		this.batches = batches;
	}

	@Override
	public String toString() {
		return "AssessScoresByCategoryAllBatches [batches=" + batches + ", aType=" + aType + "]";
	}
}
