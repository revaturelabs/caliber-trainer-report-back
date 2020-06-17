package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

//This bean does not need to go into the database. It is only used in the Java code.
public class CategoryBatches {
	private String category;
	private List<BatchAssessment> batchAssessments;
	
	public CategoryBatches()
	{
		category = "";
		batchAssessments = new ArrayList<BatchAssessment>();
	}
	
	public CategoryBatches(String category, List<BatchAssessment> batchAssessments)
	{
		this.category = category;
		this.batchAssessments = batchAssessments;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<BatchAssessment> getBatchAssessments() {
		return batchAssessments;
	}

	public void setBatchAssessments(List<BatchAssessment> batchAssessments) {
		this.batchAssessments = batchAssessments;
	}

	@Override
	public String toString() {
		return "CategoryBatches [category=" + category + ", batchAssessments=" + batchAssessments + "]";
	}
}
