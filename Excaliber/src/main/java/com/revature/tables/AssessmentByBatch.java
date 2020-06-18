package com.revature.tables;

import java.util.Arrays;

/**
 * The type Assessment by batch.
 */
public class AssessmentByBatch {
	private String batchId;
	private String batchName;
	private float[] assessmentScores;


	/**
	 * Instantiates a new Assessment by batch.
	 */
	public AssessmentByBatch() {
		batchId = "";
		batchName = "";
		assessmentScores = new float[3];
	}

	@Override
	public String toString() {
		return "AssessmentByBatch [batchId=" + batchId + ", batchName=" + batchName + ", assessmentScores="
				+ Arrays.toString(assessmentScores) + "]";
	}

	/**
	 * Gets batch id.
	 *
	 * @return the batch id
	 */
//Getters and Setters
	public String getBatchId() {
		return batchId;
	}

	/**
	 * Sets batch id.
	 *
	 * @param batchId the batch id
	 */
	public void setBatchId(String batchId) {
		this.batchId = batchId;
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
	 * Get assessment scores float [ ].
	 *
	 * @return the float [ ]
	 */
	public float[] getAssessmentScores() {
		return assessmentScores;
	}

	/**
	 * Sets assessment scores.
	 *
	 * @param assessmentScores the assessment scores
	 */
	public void setAssessmentScores(float[] assessmentScores) {
		this.assessmentScores = assessmentScores;
	}

}
