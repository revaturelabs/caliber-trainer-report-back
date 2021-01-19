package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import com.revature.beans.Assessment;
import com.revature.beans.Batch;
import com.revature.beans.BatchAssessment;
import com.revature.beans.Category;
import com.revature.beans.CategoryBatches;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.tables.AssessScoresByCategoryAllBatches;

@SpringBootTest
class AssessScoresByCategoryAllBatchesImplementTest {
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

	Trainer trainer;
	
	AssessScoresByCategoryAllBatchesImplement asabi;
	
	@MockBean
	StoreRetrieveService srs;
	
    @Test
    void getAssessScoresByCategoryAllBatches() {
    	asabi = new AssessScoresByCategoryAllBatchesImplement(srs);
    	
    	trainer= new Trainer();
		trainer.setEmail("Email");
		trainer.setEmployeeId("1");
		trainer.setFirstName("Me");
		trainer.setId(1);
		trainer.setLastName("Me 2");
		Batch batch= new Batch();
		batch.setId(1);
		batch.setBatchName("Batch name");
		batch.setEndDate("Today");
		batch.setStartDate("Yestrday");
		batch.setLocation("NewYork");
		batch.setSkill("Automated");
		batch.setTrainerId(1);
		List<Week> weeks= new ArrayList<>();
		Week week = new Week();
		week.setId(1);
		week.setBatchId("1");
		Category cat2 = new Category();
		cat2.setId(1);
		cat2.setName("Java");
		List<Category> cat = new ArrayList<>();
		cat.add(cat2);
		week.setCategories(cat);
		Assessment assess= new Assessment();
		assess.setAverage((float) 1);
		assess.setId(1);
		assess.setScoreWeight(2);
		assess.setSkillCategory(cat2);
		assess.setType("Java");
		List<Assessment> asse= new ArrayList<>();
		asse.add(assess);
		week.setAssessments(asse);
		week.setTechnicalStatus("IN progress");
		weeks.add(week);
		batch.setWeeks(weeks);
		List<Batch> batches= new ArrayList<>();
		batches.add(batch);
		trainer.setBatches(batches);

		List<Category> cats = new ArrayList<Category>();
		cats.add(cat2);
		
		ArrayList<CategoryBatches> categories = new ArrayList<>();
		ArrayList<Float> assessments = new ArrayList<>();
		 assessments.add(assess.getAverage());
		 BatchAssessment batch2 = new BatchAssessment();
		 batch2.setBatchName("Batch name");
		 batch2.setAssessments(assessments);
		 ArrayList<BatchAssessment> batches2 = new ArrayList<>();
		 batches2.add(batch2);
		 CategoryBatches catBat = new CategoryBatches();
		 catBat.setCategory("Java");
		 catBat.setBatchAssessments(batches2);
		 categories.add(catBat);
		 
		 Mockito.when(srs.getTrainerById(1)).thenReturn(trainer);
		 Mockito.when(srs.getAllCategories()).thenReturn(cats);
		 
		 AssessScoresByCategoryAllBatches catAll = new AssessScoresByCategoryAllBatches();
		 catAll.setCategories(categories);
		 
		 assertEquals(catAll.toString(),asabi.getAssessScoresByCategoryAllBatches(1).toString());
	}
	
	@Test
    void getAssessScoresByCategoryAllBatchesTestTrue() {
    	a = asbcabi.getAssessScoresByCategoryAllBatches(2);
    	b = asbcabi.getAssessScoresByCategoryAllBatches(5);
    	assertTrue(a!=b);
    }
}
