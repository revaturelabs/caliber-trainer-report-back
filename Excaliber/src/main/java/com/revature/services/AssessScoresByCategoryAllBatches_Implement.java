package com.revature.services;

import com.revature.beans.Assessment;
import com.revature.beans.Batch;
import com.revature.beans.BatchAssessment;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.tables.AssessScoresByCategoryAllBatches;

import java.util.ArrayList;

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
    public AssessScoresByCategoryAllBatches getAssessScoresByCategoryAllBatches(Integer id, String category) {
    	Trainer trainer = SRSserv.getTrainerById(id);
    	AssessScoresByCategoryAllBatches catAll = new AssessScoresByCategoryAllBatches();

        String cat = category;
        
        ArrayList<BatchAssessment> batches = new ArrayList<BatchAssessment>();
        
        for (Batch b : trainer.getBatches())
        {
        	ArrayList<Float> assessments = new ArrayList<Float>();
        	BatchAssessment batch = new BatchAssessment();
        	batch.setBatchId(b.getBatchId());
        	batch.setBatchName(b.getBatchName());
        	for (Week w : b.getWeeks())
        	{
        		for (Assessment a : w.getAssessments())
        		{
	        			if (a.getSkillCategory().getName().equalsIgnoreCase(cat))
	        			{
	        	            assessments.add(a.getAverage());
	        			}
        		}
        	}
        	batch.setAssessments(assessments);
        	batches.add(batch);
        }
        
        catAll.setBatches(batches);
        catAll.setaType(cat);
        
        return catAll;
    }

}
