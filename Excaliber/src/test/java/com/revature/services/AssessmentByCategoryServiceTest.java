package com.revature.services;

import com.revature.beans.*;

import com.revature.data.CategoryDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AssessmentByCategoryServiceTest {
	static AssessmentByCategoryService aBCServ;

	@Mock
	StoreRetrieveService mockserv;

	CategoryDAO cDao;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		aBCServ = new AssessmentByCategoryService(mockserv, cDao);

	}

//    @AfterEach
//    void tearDown() {
//    }

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

		ArrayList<ArrayList<Float>> assessScores = new ArrayList<ArrayList<Float>>();
		ArrayList<ArrayList<Float>> rawScores2 = new ArrayList<ArrayList<Float>>();
		ArrayList<ArrayList<String>> typeForScore2 = new ArrayList<ArrayList<String>>();

		assessScores.add(aScores);
		rawScores2.add(rawScores);
		typeForScore2.add(typeForScore);

		Float[] average = aBCServ.calculateAverage(0, assessScores, rawScores2, typeForScore2);
		Float[] actual = {(float) 55, (float) 50, (float) 70, (float) 50, (float) 80};
		assertArrayEquals(average, actual);
	}

	@Test
	void createABCListTest() {
		ArrayList<Category> categories = new ArrayList<Category>();
		ArrayList<Float[]> averageForCat = new ArrayList<Float[]>();
		Category c = new Category("test");
		Float[] f = {(float) 55, (float) 50, (float) 70, (float) 50, (float) 80};
		categories.add(c);
		averageForCat.add(f);

		List<AssessmentByCategory> arr = aBCServ.createABCList(categories, averageForCat);
		assertEquals(1, arr.size());
		assertTrue(arr.get(0).getCategory().contains("test"));
		assertArrayEquals(arr.get(0).getAverage(), f);
	}

	@Test
	void getABCTableTest() {
		//Setting up mock data
		Trainer t = new Trainer();
		Batch b = new Batch();
		Week w = new Week();
		Assessment a1 = new Assessment(100, "Exam", (float) 70);
		Category c = new Category();

		c.setId(1);
		c.setName("test");
		a1.setSkillCategory(c);

		ArrayList<Assessment> aList = new ArrayList<Assessment>();
		ArrayList<Category> cList = new ArrayList<Category>();
		ArrayList<Week> wList = new ArrayList<Week>();
		ArrayList<Batch> bList = new ArrayList<Batch>();

		aList.add(a1);
		w.setAssessments(aList);
		wList.add(w);
		b.setWeeks(wList);
		bList.add(b);
		t.setBatches(bList);

		cList.add(c);

		Float[] f = {(float) 70, (float) 0, (float) 0, (float) 0, (float) 0};
		//

		when(cDao.findAll()).thenReturn(cList);
		when(mockserv.getTrainerById(1)).thenReturn(t);
		List<AssessmentByCategory> testT = aBCServ.getABCTable(1);


		verify(mockserv).getTrainerById(1);
		verify(cDao).findAll();
		assertEquals(1, testT.size());
		assertEquals("test", testT.get(0).getCategory());
		assertArrayEquals(f, testT.get(0).getAverage());
	}

	@Test
	public void getTrainerAssessmentsTest() {
		//
		Trainer t = new Trainer();
		Batch b = new Batch();
		Week w = new Week();
		Assessment a1 = new Assessment(100, "Exam", (float) 70);
		Category c = new Category();

		c.setId(1);
		c.setName("test");
		a1.setSkillCategory(c);

		ArrayList<Assessment> aList = new ArrayList<Assessment>();
		ArrayList<Week> wList = new ArrayList<Week>();
		ArrayList<Batch> bList = new ArrayList<Batch>();

		aList.add(a1);
		w.setAssessments(aList);
		wList.add(w);
		b.setWeeks(wList);
		bList.add(b);
		t.setBatches(bList);
		//
		List<Assessment> tAList = aBCServ.getTrainerAssessments(t);

		assertEquals(1, tAList.size());
		assertEquals("test", tAList.get(0).getSkillCategory().getName());
		assertEquals(100, tAList.get(0).getScoreWeight());
	}
}
