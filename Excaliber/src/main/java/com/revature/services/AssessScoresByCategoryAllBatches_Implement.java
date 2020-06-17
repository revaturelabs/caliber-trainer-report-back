package com.revature.services;

import com.revature.beans.Assessment;
import com.revature.beans.Batch;
import com.revature.beans.BatchAssessment;
import com.revature.beans.Category;
import com.revature.beans.CategoryBatches;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.tables.AssessScoresByCategoryAllBatches;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Assess scores by category all batches implement.
 */
@Service
public class AssessScoresByCategoryAllBatches_Implement implements AssessScoresByCategoryAllBatches_Service {

	public Logger log = Logger.getLogger(AssessScoresByCategoryAllBatches_Implement.class);
    
	private final StoreRetrieveService SRSserv;

    /**
     * Instantiates a new Assess scores by category all batches implement.
     *
     * @param a the a
     */
    @Autowired
    public AssessScoresByCategoryAllBatches_Implement(StoreRetrieveService s) {
    	this.SRSserv = s;
    }

    /**
     * @param category
     * @return
     */
    @Override
    public AssessScoresByCategoryAllBatches getAssessScoresByCategoryAllBatches(Integer id) {
    	Trainer trainer = SRSserv.getTrainerById(id);
    	List<Category> cats = new ArrayList<Category>();
    	cats = SRSserv.getAllCategories();
    	AssessScoresByCategoryAllBatches catAll = new AssessScoresByCategoryAllBatches();

        //String cat = category;
        
        ArrayList<CategoryBatches> categories = new ArrayList<CategoryBatches>();
        
        for(Category c : cats)
        {
        	ArrayList<BatchAssessment> batches = new ArrayList<BatchAssessment>();
        	CategoryBatches catBat = new CategoryBatches();
        	String cat = c.getName();
        	catBat.setCategory(cat);
        	
	        for (Batch b : trainer.getBatches())
	        {
	        	ArrayList<Float> assessments = new ArrayList<Float>();
	        	//ArrayList<Integer> weights = new ArrayList<Integer>();
	        	BatchAssessment batch = new BatchAssessment();
	        	//batch.setBatchId(b.getBatchId());
	        	batch.setBatchName(b.getBatchName());
	        	for (Week w : b.getWeeks())
	        	{
	        		for (Assessment a : w.getAssessments())
	        		{
		        			if (a.getSkillCategory().getName().equalsIgnoreCase(cat))
		        			{
		        				
		        	            assessments.add(a.getAverage());
		        	            //weights.add(a.getScoreWeight());
		        			}
	        		}
	        	}
	        	batch.setAssessments(assessments);
	        	//batch.setWeights(weights);
	        	batches.add(batch);
	        }
	        catBat.setBatchAssessments(batches);
	        categories.add(catBat);
        }
        
        catAll.setCategories(categories);
        //catAll.setCategory(cat);
        //catAll.setBatches(batches);
        
        return catAll;
    }

}
