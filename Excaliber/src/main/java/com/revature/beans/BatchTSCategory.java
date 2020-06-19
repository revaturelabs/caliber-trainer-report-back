package com.revature.beans;

import java.util.ArrayList;

/**
 * The type Batch ts category.
 */
public class BatchTSCategory {
    private String batchName;
    private QCTSScore score;

    /**
     * Instantiates a new Batch ts category.
     */
    public BatchTSCategory() {
        this.score = new QCTSScore();
    }

    /**
     * Instantiates a new Batch ts category.
     *
     * @param categoryName the category name
     * @param batchName    the batch name
     * @param techScore    the tech score
     * @param avgVal       the avg val
     */
    public BatchTSCategory(String categoryName, String batchName, ArrayList<Double> techScore, ArrayList<Double> avgVal) {
        this.batchName = batchName;
        this.score = new QCTSScore();
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
     * Gets score.
     *
     * @return the score
     */
    public QCTSScore getScore() {
        return score;
    }

    /**
     * Sets score.
     *
     * @param score the score
     */
    public void setScore(QCTSScore score) {
        this.score = score;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((batchName == null) ? 0 : batchName.hashCode());
        result = prime * result + ((score == null) ? 0 : score.hashCode());
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
        BatchTSCategory other = (BatchTSCategory) obj;
        if (batchName == null) {
            if (other.batchName != null)
                return false;
        } else if (!batchName.equals(other.batchName))
            return false;
        if (score == null) {
            return other.score == null;
        } else return score.equals(other.score);
    }

    @Override
    public String toString() {
        return "BatchTSCategory [batchName=" + batchName + ", score=" + score + "]";
    }


}
