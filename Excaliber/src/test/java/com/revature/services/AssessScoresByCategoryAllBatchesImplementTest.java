package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.revature.tables.AssessScoresByCategoryAllBatches;

class AssessScoresByCategoryAllBatchesImplementTest {
	public AssessScoresByCategoryAllBatchesImplementTest() {
		
	}
	@Mock
	StoreRetrieveService s;
	@Mock
	AssessScoresByCategoryAllBatches a;
	@Mock
	AssessScoresByCategoryAllBatches b;
	@InjectMocks
	AssessScoresByCategoryAllBatchesImplement asbcabi;
	

    @Test
    void getAssessScoresByCategoryAllBatchesTestfalse() {
    	a = asbcabi.getAssessScoresByCategoryAllBatches(3);
    	assertFalse(a==null);
    }

    @Test
    void getAssessScoresByCategoryAllBatchesTestequals() {
    	a = asbcabi.getAssessScoresByCategoryAllBatches(6);
    	b = asbcabi.getAssessScoresByCategoryAllBatches(6);
    	assertEquals(a,b);
    }

    @Test
    void getAssessScoresByCategoryAllBatchesTestTrue() {
    	a = asbcabi.getAssessScoresByCategoryAllBatches(2);
    	b = asbcabi.getAssessScoresByCategoryAllBatches(5);
    	assertTrue(a!=b);
    }
}
