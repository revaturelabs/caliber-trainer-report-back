package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

//This bean does not need to go into the database. It is only used in the Java code.
public class BatchAssessment {
	private String batchId; //the batches id
	private String batchName; //the batches name
	private ArrayList<Float> assessments; //the assessment score for that batch over all weeks
	
	public BatchAssessment()
	{
		batchId = "";
		batchName = "";
		assessments = new ArrayList<Float>();
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public List<Float> getAssessments() {
		return assessments;
	}

	public void setAssessments(ArrayList<Float> assessments) {
		this.assessments = assessments;
	}

	@Override
	public String toString() {
		return "BatchAssessment [batchId=" + batchId + ", batchName=" + batchName + ", assessments=" + assessments
				+ "]";
	}
}
