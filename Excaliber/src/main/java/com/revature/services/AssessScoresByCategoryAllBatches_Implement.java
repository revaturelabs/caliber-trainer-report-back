package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.AssessScoresByCategoryAllBatchesMockDAO;
import com.revature.tables.AssessScoresByCategoryAllBatches;

@Service
public class AssessScoresByCategoryAllBatches_Implement implements AssessScoresByCategoryAllBatches_Service {
	AssessScoresByCategoryAllBatchesMockDAO mockDAO;
	
	@Autowired
	public AssessScoresByCategoryAllBatches_Implement(AssessScoresByCategoryAllBatchesMockDAO a)
	{
		mockDAO = a;
	}
	
	@Override
	public AssessScoresByCategoryAllBatches getAssessScoresByCategoryAllBatches(String category) {
		AssessScoresByCategoryAllBatches catAll = new AssessScoresByCategoryAllBatches();
		catAll = mockDAO.getMockData();
		return catAll;
	}

	@Override
	public void setAssessScoresByCategoryAllBatches(AssessScoresByCategoryAllBatches catAll) {
		// TODO Auto-generated method stub

	}

}
