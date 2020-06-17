package com.revature.services;

import com.revature.tables.AssessScoresByCategoryAllBatches;

/**
 * The interface Assess scores by category all batches service.
 */
public interface AssessScoresByCategoryAllBatches_Service {
    /**
     * Gets assess scores by category all batches.
     *
     * @param category the category
     * @return the assess scores by category all batches
     */
    AssessScoresByCategoryAllBatches getAssessScoresByCategoryAllBatches(Integer id);
}
