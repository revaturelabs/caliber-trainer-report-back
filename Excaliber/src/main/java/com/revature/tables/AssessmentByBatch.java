package com.revature.tables;

import java.util.Arrays;

/**
 * The type Assessment by batch.
 */
public class AssessmentByBatch {
    private String batchId;
    private String batchName;
    private float[] assessmentScores;
    
    
    public AssessmentByBatch() {
    	batchId="";
    	batchName= "";
    	assessmentScores= new float[3];
    };
    
	@Override
	public String toString() {
		return "AssessmentByBatch [batchId=" + batchId + ", batchName=" + batchName + ", assessmentScores="
				+ Arrays.toString(assessmentScores) + "]";
	}
	
	//Getters and Setters
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
	public float[] getAssessmentScores() {
		return assessmentScores;
	}
	public void setAssessmentScores(float[] assessmentScores) {
		this.assessmentScores = assessmentScores;
	}
    
}