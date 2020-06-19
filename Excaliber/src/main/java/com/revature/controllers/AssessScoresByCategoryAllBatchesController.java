package com.revature.controllers;

import com.revature.services.AssessScoresByCategoryAllBatchesService;
import com.revature.tables.AssessScoresByCategoryAllBatches;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Assess scores by category all batches controller.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/assessscoresbycategoryallbatches")
public class AssessScoresByCategoryAllBatchesController {
    private final AssessScoresByCategoryAllBatchesService catAll;
    /**
     * The Log.
     */
    public static final Logger log = Logger.getLogger(AssessScoresByCategoryAllBatchesController.class);

    /**
     * Instantiates a new Assess scores by category all batches controller.
     *
     * @param a the a
     */
    @Autowired
    public AssessScoresByCategoryAllBatchesController(AssessScoresByCategoryAllBatchesService a) {
        catAll = a;
    }

    /**
     * @param category the category
     * @return scores by category all batches
     */
    @GetMapping
    public ResponseEntity<AssessScoresByCategoryAllBatches> getScoresByCategoryAllBatches() {
        log.trace("Getting table data for AssessScoresByCategoryAllBatches");
        AssessScoresByCategoryAllBatches batches = catAll.getAssessScoresByCategoryAllBatches(1);
        return ResponseEntity.ok(batches);
    }
}
