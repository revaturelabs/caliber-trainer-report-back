package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Category batches.
 */
//This bean does not need to go into the database. It is only used in the Java code.
public class CategoryBatches {
    private String category;
    private List<BatchAssessment> batchAssessments;

    /**
     * Instantiates a new Category batches.
     */
    public CategoryBatches() {
        category = "";
        batchAssessments = new ArrayList<BatchAssessment>();
    }

    /**
     * Instantiates a new Category batches.
     *
     * @param category         the category
     * @param batchAssessments the batch assessments
     */
    public CategoryBatches(String category, List<BatchAssessment> batchAssessments) {
        this.category = category;
        this.batchAssessments = batchAssessments;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets batch assessments.
     *
     * @return the batch assessments
     */
    public List<BatchAssessment> getBatchAssessments() {
        return batchAssessments;
    }

    /**
     * Sets batch assessments.
     *
     * @param batchAssessments the batch assessments
     */
    public void setBatchAssessments(List<BatchAssessment> batchAssessments) {
        this.batchAssessments = batchAssessments;
    }

    @Override
    public String toString() {
        return "CategoryBatches [category=" + category + ", batchAssessments=" + batchAssessments + "]";
    }
}
