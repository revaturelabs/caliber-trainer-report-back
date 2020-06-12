package com.revature.tables;

import java.util.Arrays;

public class AssessmentByCategory {
    private Integer batchId;
    private String batchName;
    private String assessmentType;
    private Double[] scores;

    public AssessmentByCategory(Integer numOfScores) {
        batchId = 0;
        batchName = "";
        assessmentType = "";
        scores = new Double[numOfScores];
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }

    public Double[] getScores() {
        return scores;
    }

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
