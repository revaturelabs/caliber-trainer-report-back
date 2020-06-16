package com.revature.tables;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BatchAssessment;

/**
 * The type Assess scores by category all batches.
 */
public class AssessScoresByCategoryAllBatches {
	private String category; //type of assessment: test, verbal, project etc.
	private List<BatchAssessment> batches; //the list of all of the batches with their assessment scores

    //add dates maybe?
    //private List<Date> startDates; //corresponding start dates


    /**
     * Instantiates a new Assess scores by category all batches.
     */
//two constructors
    public AssessScoresByCategoryAllBatches() {
    	category = "";
    	batches = new ArrayList<BatchAssessment>();
    }


    /**
     * Instantiates a new Assess scores by category all batches.
     *
     * @param batches	 the batches with scores attached
     * @param category      the category
     */
    public AssessScoresByCategoryAllBatches(List<BatchAssessment> batches, String category) {
    	this.category = category;
    	this.batches = batches;
    }

//Getters and Setters
    /**
     * Gets type.
     *
     * @return the type
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets type.
     *
     * @param aType the a type
     */
    public void setCategory(String category) {
        this.category = category;
    }
    
	public List<BatchAssessment> getBatches() {
		return batches;
	}

	public void setBatches(List<BatchAssessment> batches) {
		this.batches = batches;
	}

	@Override
	public String toString() {
		return "AssessScoresByCategoryAllBatches [category=" + category + ", batches=" + batches + "]";
	}
}
