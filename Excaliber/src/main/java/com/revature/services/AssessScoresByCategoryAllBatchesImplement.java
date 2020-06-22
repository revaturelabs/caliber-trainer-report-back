package com.revature.services;

import com.revature.beans.*;
import com.revature.tables.AssessScoresByCategoryAllBatches;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Assess scores by category all batches implement.
 */
@Service
public class AssessScoresByCategoryAllBatchesImplement implements AssessScoresByCategoryAllBatchesService {

    public static final Logger log = Logger.getLogger(AssessScoresByCategoryAllBatchesImplement.class);

    private final StoreRetrieveService SRSserv;

    /**
     * Instantiates a new Assess scores by category all batches implement.
     *
     * @param a the a
     */
    @Autowired
    public AssessScoresByCategoryAllBatchesImplement(StoreRetrieveService s) {
        this.SRSserv = s;
    }

    /**
     * @param category
     * @return
     */
    @Override
    public AssessScoresByCategoryAllBatches getAssessScoresByCategoryAllBatches(Integer id) {
        Trainer trainer = SRSserv.getTrainerById(id);
        List<Category> cats;
        cats = SRSserv.getAllCategories();
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
