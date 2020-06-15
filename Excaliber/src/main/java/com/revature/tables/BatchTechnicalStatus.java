package com.revature.tables;

/**
 * Batch Technical Status Bean
 * <p>
 * Bean to generate graph for Technical Status per batch***
 * <p>
 * User Story:
 * • To generate graphical representation of QC Technical Status
 * according to the batch.
 * <p>
 * Objective:
 * •Generate the metrics that allows to see how well a trainer is
 * performing per batch.
 * <p>
 * Data-Points:
 * •Batch ID from Batch
 * •Batch Name from Batch
 * •Technical Status from Batch's QC notes.
 * •Assessment Score from Batch's Assessment in percentage.
 * •Raw Score from Batch's Assessment in percentage.
 */
public class BatchTechnicalStatus {
    private Integer batchId;            // ID number of a batch
    private String batchName;            // Name of a batch
    private String technicalStatus;        // GOOD, BAD, etc for batch
    private Double rawScore;            // Highest score a batch can score in %
    private Double assessmentScore;        // Actual score scored by a batch in %

    /**
     * Instantiates a new Batch technical status.
     */
//Constructor
    public BatchTechnicalStatus() {
        batchId = null;
        batchName = "";
        technicalStatus = "";
        rawScore = null;
        assessmentScore = null;
    }

    /**
     * Gets batch id.
     *
     * @return the batch id
     */
// getters and setters
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
     * Gets technical status.
     *
     * @return the technical status
     */
    public String getTechnicalStatus() {
        return technicalStatus;
    }

    /**
     * Sets technical status.
     *
     * @param technicalStatus the technical status
     */
    public void setTechnicalStatus(String technicalStatus) {
        this.technicalStatus = technicalStatus;
    }

    /**
     * Gets raw score.
     *
     * @return the raw score
     */
    public Double getRawScore() {
        return rawScore;
    }

    /**
     * Sets raw score.
     *
     * @param rawScore the raw score
     */
    public void setRawScore(Double rawScore) {
        this.rawScore = rawScore;
    }

    /**
     * Gets assessment score.
     *
     * @return the assessment score
     */
    public Double getAssessmentScore() {
        return assessmentScore;
    }

    /**
     * Sets assessment score.
     *
     * @param assessmentScore the assessment score
     */
    public void setAssessmentScore(Double assessmentScore) {
        this.assessmentScore = assessmentScore;
    }

    //Generate hascode and equals

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((assessmentScore == null) ? 0 : assessmentScore.hashCode());
        result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
        result = prime * result + ((batchName == null) ? 0 : batchName.hashCode());
        result = prime * result + ((rawScore == null) ? 0 : rawScore.hashCode());
        result = prime * result + ((technicalStatus == null) ? 0 : technicalStatus.hashCode());
        return result;
    }

    //Generate toString()
    @Override
    public String toString() {
        return "BatchTechnicalStatus [batchId=" + batchId + ", batchName=" + batchName + ", technicalStatus="
                + technicalStatus + ", rawScore=" + rawScore + ", assessmentScore=" + assessmentScore + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BatchTechnicalStatus other = (BatchTechnicalStatus) obj;
        if (assessmentScore == null) {
            if (other.assessmentScore != null)
                return false;
        } else if (!assessmentScore.equals(other.assessmentScore))
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
        if (rawScore == null) {
            if (other.rawScore != null)
                return false;
        } else if (!rawScore.equals(other.rawScore))
            return false;
        if (technicalStatus == null) {
            return other.technicalStatus == null;
        } else return technicalStatus.equals(other.technicalStatus);
    }


}
