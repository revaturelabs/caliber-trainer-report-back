package com.revature.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;

import com.revature.services.AssessScoresByCategoryAllBatches_Implement;
import com.revature.tables.AssessScoresByCategoryAllBatches;

public class AssessScoresByCategoryAllBatchesTests {
	AssessScoresByCategoryAllBatches_Implement catAllImp;
	
	AssessScoresByCategoryAllBatches catAllMock = new AssessScoresByCategoryAllBatches();
	
	@Test
	public void testGetAssessScoresByCategoryAllBatches()
	{
		//catAllMock = catAllImp.getAssessScoresByCategoryAllBatches("");
		
		//assertFalse(catAllImp.getAssessScoresByCategoryAllBatches(""));
	}
}
