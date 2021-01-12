package com.revature.services;

import com.revature.beans.Assessment;
import com.revature.beans.AssessmentByBatch;
import com.revature.beans.Batch;
import com.revature.beans.Trainer;
import com.revature.beans.Week;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AssessmentByBatchServiceTest {
	static AssessmentByBatchService aBBServ;
	@Mock
	StoreRetrieveService mockserv;


	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		aBBServ = new AssessmentByBatchService(mockserv);

	}

	@Test
	void calculateAverageTest() {
		ArrayList<Float> aScores = new ArrayList<Float>();
		aScores.add((float) 50);
		aScores.add((float) 60);
		aScores.add((float) 70);
		aScores.add((float) 80);
		aScores.add((float) 50);
		aScores.add((float) 50);
		aScores.add((float) 50);
		aScores.add((float) 50);
		ArrayList<Float> rawScores = new ArrayList<Float>();
		rawScores.add((float) 100);
		rawScores.add((float) 100);
		rawScores.add((float) 100);
		rawScores.add((float) 100);
		rawScores.add((float) 200);
		rawScores.add((float) 100);
		rawScores.add((float) 150);
		rawScores.add((float) 50);
		ArrayList<String> typeForScore = new ArrayList<String>();
		typeForScore.add("Exam");
		typeForScore.add("Exam");
		typeForScore.add("Presentation");
		typeForScore.add("m");
		typeForScore.add("Verbal");
		typeForScore.add("Verbal");
		typeForScore.add("Project");
		typeForScore.add("Project");

		float[] arr = aBBServ.calculateAverages(aScores, rawScores, typeForScore);
		float[] actual = {(float) 55, (float) 50, (float) 70, (float) 50, (float) 80};
		assertArrayEquals(arr, actual);
	}

	@Test
	void loopBatchesTest() {
		Assessment a1 = new Assessment(150, "Exam", (float) 70);
		Week w = new Week();
		ArrayList<Assessment> aList = new ArrayList<Assessment>();
		aList.add(a1);
		w.setAssessments(aList);
		ArrayList<Week> wList = new ArrayList<Week>();
		wList.add(w);
		Batch b = new Batch();
		b.setBatchId("testId");
		b.setBatchName("testName");
		b.setWeeks(wList);
		ArrayList<Batch> bList = new ArrayList<Batch>();
		bList.add(b);

		List<AssessmentByBatch> aBBList = aBBServ.loopBatches(bList);
		float[] arr = {(float) 70, (float) 0, (float) 0, (float) 0, (float) 0};
		assertTrue(aBBList.size() == 1);
		assertTrue(aBBList.get(0).getBatchId().contains("testId"));
		assertTrue(aBBList.get(0).getBatchName().contains("testName"));
		assertArrayEquals(aBBList.get(0).getAssessmentScores(), arr);

	}

	@Test
	void getABBTableTest() {

		//Setting up mock data
		Trainer t = new Trainer();
		Batch b = new Batch();
		Assessment a1 = new Assessment(100, "Exam", (float) 70);
		Week w = new Week();
		ArrayList<Assessment> aList = new ArrayList<Assessment>();
		aList.add(a1);
		w.setAssessments(aList);
		ArrayList<Week> wList = new ArrayList<Week>();
		wList.add(w);
		b.setBatchId("testId");
		b.setBatchName("testName");
		b.setWeeks(wList);
		ArrayList<Batch> batches = new ArrayList<Batch>();
		batches.add(b);
		t.setBatches(batches);
		//

		when(mockserv.getTrainerById(1)).thenReturn(t);
		aBBServ.getABBTable(1);
		verify(mockserv).getTrainerById(1);
	}

}
