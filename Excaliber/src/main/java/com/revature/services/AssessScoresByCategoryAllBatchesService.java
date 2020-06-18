package com.revature.services;

import com.revature.beans.*;
import com.revature.tables.AssessScoresByCategoryAllBatches;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The interface Assess scores by category all batches service.
 */
@Service
public class AssessScoresByCategoryAllBatchesService {


    /**
     * The Log.
     */
    private final Logger log = Logger.getLogger(AssessScoresByCategoryAllBatchesService.class);
    private final StoreRetrieveService sRSserv;


    /**
     * Instantiates a new Assess scores by category all batches implement.
     *
     * @param s the s
     */
    @Autowired
    public AssessScoresByCategoryAllBatchesService(StoreRetrieveService s) {
        this.sRSserv = s;
    }

    /**
     * Gets assess scores by category all batches.
     *
     * @param id the id
     * @return the assess scores by category all batches
     */
    public AssessScoresByCategoryAllBatches getAssessScoresByCategoryAllBatches(Integer id) {
        log.trace("AssessScoresByCategoryAllBatchesService ID= " + id);
        Trainer trainer = sRSserv.getTrainerById(id);
        List<Category> cats;
        cats = sRSserv.getAllCategories();
        AssessScoresByCategoryAllBatches catAll = new AssessScoresByCategoryAllBatches();
        ArrayList<CategoryBatches> categories = new ArrayList<>();

        for (Category c : cats) {
            ArrayList<BatchAssessment> batches = new ArrayList<>();
            CategoryBatches catBat = new CategoryBatches();
            String cat = c.getName();
            catBat.setCategory(cat);

            for (Batch b : trainer.getBatches()) {
                ArrayList<Float> assessments = new ArrayList<>();
                BatchAssessment batch = new BatchAssessment();
                batch.setBatchName(b.getBatchName());
                for (Week w : b.getWeeks()) {
                    for (Assessment a : w.getAssessments()) {
                        if (a.getSkillCategory().getName().equalsIgnoreCase(cat)) {

                            assessments.add(a.getAverage());
                        }
                    }
                }
                batch.setAssessments(assessments);
                batches.add(batch);
            }
            catBat.setBatchAssessments(batches);
            categories.add(catBat);
        }

        catAll.setCategories(categories);

        return catAll;
    }
}
