package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Assessment;
import com.revature.beans.Batch;
import com.revature.beans.Category;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.tables.AssessmentByCategory;

@Service
public class AssessmentByCategoryService {
	private StoreRetrieveService SRSserv;
	@Autowired
	public AssessmentByCategoryService(StoreRetrieveService s) {
		SRSserv=s;
	}
	
	public AssessmentByCategory getABCTable(int id) {
		Trainer t=SRSserv.getTrainerById(id);
		AssessmentByCategory table=new AssessmentByCategory();
		
		List<Category> categories=SRSserv.getAllCategories();
	    ArrayList<ArrayList<Float>> assessScores=new ArrayList<ArrayList<Float>>(); ;
	    ArrayList<ArrayList<Float>> rawScores=new ArrayList<ArrayList<Float>>();
	    ArrayList<Float> averageForCat=new ArrayList<Float>();
	    
	    //Get rawScores and AssessmentScores for each category
	    for (Category cat:categories) {
	    	ArrayList<Float> singleCatAScores=new ArrayList<Float>();
	    	ArrayList<Float> singleCatRawScores=new ArrayList<Float>();
		    for (Batch b:t.getBatches()) {
		    	for (Week w:b.getWeeks()) {
		    		for (Assessment a:w.getAssessments()) {
		    			if (a.getSkillCategory().getId()==cat.getId()) {
		    				Float assessScore=a.getAverage();
		    				Float rawScore=Float.valueOf(a.getScoreWeight());
		    				assessScore=(assessScore/100)*rawScore; //Convert AssessScore into suitable form
		    				singleCatAScores.add(assessScore);
		    				singleCatRawScores.add(rawScore);
		    			}
		    			
		    		}
		    	}
		    }
		    assessScores.add(singleCatAScores); //Add scores for single category to list
		    rawScores.add(singleCatRawScores);
	    
	    }
	    //Find average overall score for each category
	    for (int i=0;i<assessScores.size();i++) {
	    	float numerator=0;
	    	float denominator=0;
	    	for (float f:assessScores.get(i)) {
	    		numerator+=f;
	    	}
	    	for (float f:rawScores.get(i)) {
	    		denominator+=f;
	    	}
	    	float average=(numerator/denominator)*100;
	    	averageForCat.add(average);
	    }
	    
	    
	    table.setCategories(categories);
	    
	    table.setAverage(averageForCat);
		return table;
	}
}
