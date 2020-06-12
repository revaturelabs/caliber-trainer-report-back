package com.revature.services;

import com.revature.tables.AssessScoresByCategoryAllBatches;

public interface AssessScoresByCategoryAllBatches_Service {
    AssessScoresByCategoryAllBatches getAssessScoresByCategoryAllBatches(String category);

    void setAssessScoresByCategoryAllBatches(AssessScoresByCategoryAllBatches catAll);
}
