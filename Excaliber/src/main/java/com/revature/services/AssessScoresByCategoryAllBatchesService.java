package com.revature.services;

import com.revature.beans.AssessScoresByCategoryAllBatches;

/**
 * The interface Assess scores by category all batches service.
 */
public interface AssessScoresByCategoryAllBatchesService {
    /**
     * Gets assess scores by category all batches.
     *
     * @param category the category
     * @return the assess scores by category all batches
     */
    AssessScoresByCategoryAllBatches getAssessScoresByCategoryAllBatches(Integer id);
}
