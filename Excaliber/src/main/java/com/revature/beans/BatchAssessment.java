package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

//This bean does not need to go into the database. It is only used in the Java code.
public class BatchAssessment {
	private String batchId; //the batches id
	private String batchName; //the batches name
	private ArrayList<Float> assessments; //the assessment score for that batch over all weeks
	private ArrayList<Integer> weights; //how much an assessment counts towards the average
	
	public BatchAssessment()
	{
		batchId = "";
		batchName = "";
		assessments = new ArrayList<Float>();
		weights = new ArrayList<Integer>();
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

	public ArrayList<Integer> getWeights() {
		return weights;
	}

	public void setWeights(ArrayList<Integer> weights) {
		this.weights = weights;
	}

	@Override
	public String toString() {
		return "BatchAssessment [batchId=" + batchId + ", batchName=" + batchName + ", assessments=" + assessments
				+ ", weights=" + weights + "]";
	}
}
