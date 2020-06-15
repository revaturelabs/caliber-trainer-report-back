package com.revature.tables;

import java.util.Arrays;

/**
 * The type Assessment by category.
 */
public class AssessmentByCategory {
    private Integer batchId;
    private String batchName;
    private String assessmentType;
    private Double[] scores;

    /**
     * Instantiates a new Assessment by category.
     *
     * @param numOfScores the num of scores
     */
    public AssessmentByCategory(Integer numOfScores) {
        batchId = 0;
        batchName = "";
        assessmentType = "";
        scores = new Double[numOfScores];
    }

    /**
     * Gets batch id.
     *
     * @return the batch id
     */
    public Integer getBatchId() {
        return batchId;
    }

    /**
     * Sets batch id.
     *
     * @param batchId the batch id
     */
    public void setBatchId(Integer batchId) {
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
     * Gets assessment type.
     *
     * @return the assessment type
     */
    public String getAssessmentType() {
        return assessmentType;
    }

    /**
     * Sets assessment type.
     *
     * @param assessmentType the assessment type
     */
    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }

    /**
     * Get scores double [ ].
     *
     * @return the double [ ]
     */
    public Double[] getScores() {
        return scores;
    }

    /**
     * Sets scores.
     *
     * @param scores the scores
     */
    public void setScores(Double[] scores) {
        this.scores = scores;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((assessmentType == null) ? 0 : assessmentType.hashCode());
        result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
        result = prime * result + ((batchName == null) ? 0 : batchName.hashCode());
        result = prime * result + Arrays.hashCode(scores);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AssessmentByCategory other = (AssessmentByCategory) obj;
        if (assessmentType == null) {
            if (other.assessmentType != null)
                return false;
        } else if (!assessmentType.equals(other.assessmentType))
            return false;
        if (batchId == null) {
            if (other.batchId != null)
                return false;
        } else if (!batchId.equals(other.batchId))
            return false;
        if (batchName == null) {
            if (other.batchName != null)
                return false;
        } else if (!batchName.equals(other.batchName))
            return false;
        return Arrays.equals(scores, other.scores);
    }

    @Override
    public String toString() {
        return "AssessmentByCategory [batchId=" + batchId + ", batchName=" + batchName + ", assessmentType="
                + assessmentType + ", scores=" + Arrays.toString(scores) + "]";
    }


}
