package com.revature.services;

import com.revature.tables.AssessScoresByCategoryAllBatches;

public interface AssessScoresByCategoryAllBatches_Service {
    AssessScoresByCategoryAllBatches getAssessScoresByCategoryAllBatches(String category);

    /**
     * TODO
     *
     * @param catAll
     */
    void setAssessScoresByCategoryAllBatches(AssessScoresByCategoryAllBatches catAll);
}
