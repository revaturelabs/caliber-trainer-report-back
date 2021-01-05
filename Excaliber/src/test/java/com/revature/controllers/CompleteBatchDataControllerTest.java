package com.revature.controllers;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.revature.beans.Batch;
import com.revature.beans.CompleteBatch;

@ExtendWith(MockitoExtension.class)
public class CompleteBatchDataControllerTest {
	
	@Mock
	CompleteBatchDataController cont = new CompleteBatchDataController();
	
	@Test
	public void testgetCompleteBatchDataByIdContainsQC()
	{
		ResponseEntity<CompleteBatch> resp = cont.getCompleteBatchDataById(1);
		Mockito.verify(cont).getCompleteBatchDataById(1);
		
		assertTrue(resp.getBody().getQCNotes().size() > 0);
	}
	
	@Test
	public void testgetCompleteBatchDataByIdContainsAssessments()
	{
		ResponseEntity<CompleteBatch> resp = cont.getCompleteBatchDataById(1);
		Mockito.verify(cont).getCompleteBatchDataById(1);
		
		assertTrue(resp.getBody().getAssessments().size() > 0);
	}
	
	@Test
	public void testgetCompleteBatchDataByIdContainsData()
	{
		ResponseEntity<CompleteBatch> resp = cont.getCompleteBatchDataById(1);
		Mockito.verify(cont).getCompleteBatchDataById(1);
		
		assertTrue(resp.getBody().getId() > 0);
		assertTrue(resp.getBody().getBatchId() != "");
		assertTrue(resp.getBody().getStartDate() != "");
		assertTrue(resp.getBody().getEndDate() != "");
		assertTrue(resp.getBody().getSkill() != "");
		assertTrue(resp.getBody().getLocation() != "");
		assertTrue(resp.getBody().getType() != "");
		assertTrue(resp.getBody().getCurrentWeek() > 0);
	}
	
	
}
