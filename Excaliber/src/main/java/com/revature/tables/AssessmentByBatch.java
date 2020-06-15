package com.revature.tables;

/**
 * The type Assessment by batch.
 */
public class AssessmentByBatch {
    private Integer batchId;
    private String batchName;
    private String type;
    private Integer score;

    /**
     * Instantiates a new Assessment by batch.
     *
     * @param batchId   the batch id
     * @param batchName the batch name
     * @param type      the type
     * @param score     the score
     */
    public AssessmentByBatch(Integer batchId, String batchName, String type, Integer score) {
        super();
        this.batchId = batchId;
        this.batchName = batchName;
        this.type = type;
        this.score = score;
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
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * Sets score.
     *
     * @param score the score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
        result = prime * result + ((batchName == null) ? 0 : batchName.hashCode());
        result = prime * result + ((score == null) ? 0 : score.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        AssessmentByBatch other = (AssessmentByBatch) obj;
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
        if (score == null) {
            if (other.score != null)
                return false;
        } else if (!score.equals(other.score))
            return false;
        if (type == null) {
            return other.type == null;
        } else return type.equals(other.type);
    }

    @Override
    public String toString() {
        return "AssessmentByBatch [batchId=" + batchId + ", batchName=" + batchName + ", type=" + type + ", score="
                + score + "]";
    }


}
