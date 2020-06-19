package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.beans.Category;
import com.revature.tables.AssessmentByCategory;

class AssessmentByCategoryServiceTest {
	static AssessmentByCategoryService aBCServ;
	
	@Mock
	StoreRetrieveService mockserv;
		
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		aBCServ=new AssessmentByCategoryService(mockserv);
		
	}

//    @AfterEach
//    void tearDown() {
//    }

    @Test
    void calculateAverageTest() {
		ArrayList<Float> aScores= new ArrayList<Float>();
		aScores.add((float) 50); aScores.add((float) 60);aScores.add((float) 70);aScores.add((float) 80);
		aScores.add((float) 50); aScores.add((float) 50);
		aScores.add((float) 50); aScores.add((float) 50);
		ArrayList<Float> rawScores= new ArrayList<Float>();
		rawScores.add((float) 100); rawScores.add((float) 100);rawScores.add((float) 100);rawScores.add((float) 100);
		rawScores.add((float) 200); rawScores.add((float) 100);
		rawScores.add((float) 150); rawScores.add((float) 50);
		ArrayList<String> typeForScore= new ArrayList<String>();
		typeForScore.add("Exam");typeForScore.add("Exam");typeForScore.add("Presentation");typeForScore.add("m");
		typeForScore.add("Verbal");typeForScore.add("Verbal");
		typeForScore.add("Project");typeForScore.add("Project");
		
		ArrayList<ArrayList<Float>> assessScores=new ArrayList<ArrayList<Float>>();
		ArrayList<ArrayList<Float>> rawScores2=new ArrayList<ArrayList<Float>>();
		ArrayList<ArrayList<String>> typeForScore2=new ArrayList<ArrayList<String>>();
		
		assessScores.add(aScores);
		rawScores2.add(rawScores);
		typeForScore2.add(typeForScore);
		
		Float[] average=aBCServ.calculateAverage(0, assessScores, rawScores2, typeForScore2);
		Float[] actual= {(float)55,(float)50,(float)70,(float)50,(float)80};
		assertArrayEquals(average,actual);
    }
    
    @Test
    void createABCListTest() {
    	ArrayList<Category> categories=new ArrayList<Category>();
    	ArrayList<Float[]> averageForCat=new ArrayList<Float[]>();
    	Category c=new Category("test");
    	Float[] f= {(float)55,(float)50,(float)70,(float)50,(float)80};
    	categories.add(c);
    	averageForCat.add(f);
    	
    	List<AssessmentByCategory> arr=aBCServ.createABCList(categories, averageForCat);
    	assertEquals(1,arr.size());
    	assertTrue(arr.get(0).getCategory().contains("test"));
    	assertArrayEquals(arr.get(0).getAverage(),f);
    }
}
