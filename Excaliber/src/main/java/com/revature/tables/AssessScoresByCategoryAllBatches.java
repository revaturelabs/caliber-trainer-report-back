package com.revature.tables;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BatchAssessment;
import com.revature.beans.CategoryBatches;

/**
 * The type Assess scores by category all batches.
 */
public class AssessScoresByCategoryAllBatches {
	private List<CategoryBatches> categories; //type of assessment: test, verbal, project etc.
	//private List<BatchAssessment> batches; //the list of all of the batches with their assessment scores

    //add dates maybe?
    //private List<Date> startDates; //corresponding start dates


    /**
     * Instantiates a new Assess scores by category all batches.
     */
//two constructors
    public AssessScoresByCategoryAllBatches() {
    	categories = new ArrayList<CategoryBatches>();
    	//batches = new ArrayList<BatchAssessment>();
    }


    /**
     * Instantiates a new Assess scores by category all batches.
     *
     * @param batches	 the batches with scores attached
     * @param category      the category
     */
    public AssessScoresByCategoryAllBatches(List<BatchAssessment> batches, String category) {
    	//this.category = category;
    	//this.batches = batches;
    }
    
    public AssessScoresByCategoryAllBatches(List<CategoryBatches> categories)
    {
    	this.categories = categories;
    }

public List<CategoryBatches> getCategories() {
		return categories;
	}


	public void setCategories(List<CategoryBatches> categories) {
		this.categories = categories;
	}


@Override
	public String toString() {
		return "AssessScoresByCategoryAllBatches [categories=" + categories + "]";
	}
}
