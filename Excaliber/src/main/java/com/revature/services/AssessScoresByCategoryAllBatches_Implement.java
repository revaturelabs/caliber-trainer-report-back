package com.revature.services;

import com.revature.data.AssessScoresByCategoryAllBatchesMockDAO;
import com.revature.tables.AssessScoresByCategoryAllBatches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessScoresByCategoryAllBatches_Implement implements AssessScoresByCategoryAllBatches_Service {
    AssessScoresByCategoryAllBatchesMockDAO mockDAO;

    @Autowired
    public AssessScoresByCategoryAllBatches_Implement(AssessScoresByCategoryAllBatchesMockDAO a) {
        mockDAO = a;
    }

    /**
     * @param category
     * @return
     */
    @Override
    public AssessScoresByCategoryAllBatches getAssessScoresByCategoryAllBatches(String category) {
        AssessScoresByCategoryAllBatches catAll = new AssessScoresByCategoryAllBatches();
        catAll = mockDAO.getMockData();
        return catAll;
    }

    /**
     * @param catAll
     */
    @Override
    public void setAssessScoresByCategoryAllBatches(AssessScoresByCategoryAllBatches catAll) {
        // TODO Auto-generated method stub

    }

}
